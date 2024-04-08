package quests;

import java.util.Scanner;

public class AdditionsSub {
    public Scanner scanner;

    public AdditionsSub() {
        this.scanner = new Scanner(System.in);
    }

    public int additionsSubsWithParamsReturn() {
        System.out.print("firstNumber: ");
        int firstNumber = scanner.nextInt();

        System.out.print("secondNumber: ");
        int secondNumber = scanner.nextInt();

        int result = firstNumber + secondNumber;

        System.out.println("AdditionsSub = additionsSubsWithParamsReturn()");
        System.out.println("params : firstNumber-" + firstNumber + ", secondNumber-" + secondNumber);
        return result;
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
