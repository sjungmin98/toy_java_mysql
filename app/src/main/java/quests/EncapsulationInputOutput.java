package quests;

import java.util.Scanner;

public class EncapsulationInputOutput {
    private Scanner scanner;
    private EncapsulationSub calculations;

    public EncapsulationInputOutput() {
        this.scanner = new Scanner(System.in);
        this.calculations = new EncapsulationSub();
    }

    public void Calculations() {
        try {
            System.out.print("firstNumber: ");
            int firstNumber = scanner.nextInt();

            System.out.print("secondNumber: ");
            int secondNumber = scanner.nextInt();

            calculations.setFirstNumber(firstNumber);
            calculations.setSecondNumber(secondNumber);

            String divisionResult = calculations.divide();
            System.out.println("Division: " + divisionResult);
        } 
        catch (Exception e) {

        } 
        finally {
            scanner.close();
        }
    }
}
