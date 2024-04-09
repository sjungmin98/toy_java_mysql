package quests;

public class ArithmeticsSub {
    public int add(int firstNumber, int secondNumber) {
        try {
            return firstNumber + secondNumber;
        } catch (Exception e) {
            return 0; 
        }
    }

    public int subtract(int firstNumber, int secondNumber) {
        try {
            return firstNumber - secondNumber;
        } catch (Exception e) {
            return 0;
        }
    }

    public int multiply(int firstNumber, int secondNumber) {
        try {
            return firstNumber * secondNumber;
        } catch (Exception e) {
            return 0;
        }
    }

    public String divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return "Error!";
        }
        int divisionResult = firstNumber / secondNumber;
        int remainder = firstNumber % secondNumber;
        return String.format("[%d/%d]", divisionResult, remainder);
    }
}
