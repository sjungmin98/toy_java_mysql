package quests;

import java.util.Scanner; // Scanner 클래스를 사용하기 위해 java.util 패키지에서 임포트합니다.

public class AdditionsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("firstNumber: ");
        int firstNumber = scanner.nextInt();
        System.out.print("secondNumber: ");
        int secondNumber = scanner.nextInt();
    
        AdditionsSub subs = new AdditionsSub();
        
        int result = subs.additionsSubsWithParamsReturn(firstNumber, secondNumber);

        System.out.println("Addition: " + result);
        
        scanner.close();
    }
}
