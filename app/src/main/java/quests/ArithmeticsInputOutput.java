package quests;

import java.util.Scanner;

public class ArithmeticsInputOutput {
    public Scanner scanner;
    public ArithmeticsSub calculations;

    public ArithmeticsInputOutput() {
        this.scanner = new Scanner(System.in);
        this.calculations = new ArithmeticsSub();
    }

    public void Calculations() {
        System.out.print("firstNumber: ");
        int firstNumber = scanner.nextInt();

        System.out.print("secondNumber: ");
        int secondNumber = scanner.nextInt();

        String divisionResult = calculations.divide(firstNumber, secondNumber);
        
        System.out.println("Addition: " + calculations.add(firstNumber, secondNumber));
        System.out.println("Subtraction: " + calculations.subtract(firstNumber, secondNumber));
        System.out.println("Multiplication: " + calculations.multiply(firstNumber, secondNumber));
        
        if (divisionResult.equals("Error!")) {
            System.out.println("Division: Error!");
        } else {
            System.out.println("Division: " + divisionResult);
        }

        closeScanner();
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
