package toyquests;

import java.sql.*;
import java.util.Scanner;

public class ToyQuestsSQL {
    static final String DB_URL = "jdbc:mysql://java_mysql_mysql/java_mysql";
    static final String USER = "cocolabhub";
    static final String PASS = "cocolabhub";
    private int totalScore = 0; 

    public static void main(String[] args) {
        new ToyQuestsSQL().run();
    }

    private void run() {
        // 문제 프로그램 실행
        Scanner scanner = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            resetTables(conn);

            String continueResponse;
            do {
                System.out.println("응답자 이름을 입력하세요:");
                String respondentName = scanner.nextLine();

                int respondentId = insertRespondent(conn, respondentName);

                System.out.println("문제 유형을 입력하세요 (4지 선다형):");
                scanner.nextLine();

                System.out.println("문항 수를 입력하세요:");
                int questionCount = Integer.parseInt(scanner.nextLine());

                processQuestions(conn, scanner, respondentId, questionCount);

                System.out.println("총점: " + totalScore);

                System.out.println("다음 응시자 여부(계속:c, 종료:x):");
                continueResponse = scanner.nextLine();
                totalScore = 0; 
            } while ("c".equalsIgnoreCase(continueResponse));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    // 코드 시작 시 Responses, Respodents 테이블 초기화
    private static void resetTables(Connection conn) throws SQLException {
        String sqlDeleteResponses = "DELETE FROM Responses";
        String sqlDeleteRespondents = "DELETE FROM Respondents";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlDeleteResponses);
            stmt.executeUpdate(sqlDeleteRespondents);

            String sqlResetAutoIncrementResponses = "ALTER TABLE Responses AUTO_INCREMENT = 1";
            String sqlResetAutoIncrementRespondents = "ALTER TABLE Respondents AUTO_INCREMENT = 1";
            stmt.executeUpdate(sqlResetAutoIncrementResponses);
            stmt.executeUpdate(sqlResetAutoIncrementRespondents);
        }
    }

    // SQL에 INPUT받은 응답자 추가
    private static int insertRespondent(Connection conn, String respondentName) throws SQLException {
        String sql = "INSERT INTO Respondents (respondent_name) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, respondentName);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1; 
    }

    // Questions 테이블에서 문제 데이터 가져와서 출력
    private void processQuestions(Connection conn, Scanner scanner, int respondentId, int questionCount) throws SQLException {
        String sql = "SELECT question_id, question_text, question_score FROM Questions ORDER BY question_order LIMIT ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, questionCount);
            ResultSet rsQuestions = pstmt.executeQuery();
    
            int questionNumber = 0;
            while (rsQuestions.next()) {
                questionNumber++;
                int questionId = rsQuestions.getInt("question_id");
                String questionText = rsQuestions.getString("question_text");
                int questionScore = rsQuestions.getInt("question_score");
    
                System.out.println("문항" + questionNumber + ": " + questionText);
    
                displayChoices(conn, questionId);
    
                System.out.print("\n정답: ");
                int choiceOrder = Integer.parseInt(scanner.nextLine());
    
                boolean isCorrect = insertResponse(conn, respondentId, questionId, choiceOrder);
                if (isCorrect) {
                    totalScore += questionScore;
                }
            }
        }
    }

    // 문제에 대한 선택지 가져온 후 출력
    private static void displayChoices(Connection conn, int questionId) throws SQLException {
        String sql = "SELECT choices_order, choices FROM Choices WHERE question_id = ? ORDER BY choices_order";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, questionId);
            ResultSet rsChoices = pstmt.executeQuery();

            StringBuilder choicesLine = new StringBuilder();
            while (rsChoices.next()) {
                int choicesOrder = rsChoices.getInt("choices_order");
                String choice = rsChoices.getString("choices");
                choicesLine.append(choicesOrder).append(") ").append(choice).append("   ");
            }

            System.out.print(choicesLine.toString());
        }
    }

    // 응답자 INPUT 및 정답 여부 SQL에 저장
    private boolean insertResponse(Connection conn, int respondentId, int questionId, int choiceOrder) throws SQLException {
        String findChoiceSql = "SELECT is_correct FROM Choices WHERE question_id = ? AND choices_order = ?";
        boolean isCorrectAnswer = false;
        try (PreparedStatement findStmt = conn.prepareStatement(findChoiceSql)) {
            findStmt.setInt(1, questionId);
            findStmt.setInt(2, choiceOrder);
            ResultSet rs = findStmt.executeQuery();
            if (rs.next()) {
                String isCorrect = rs.getString("is_correct");
                isCorrectAnswer = "O".equals(isCorrect);
    
                String sql = "INSERT INTO Responses (respondent_id, question_id, is_correct) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, respondentId);
                    pstmt.setInt(2, questionId);
                    pstmt.setString(3, isCorrect != null ? isCorrect : "X");
                    pstmt.executeUpdate();
                }
            }
        }
        return isCorrectAnswer;
    }
}
