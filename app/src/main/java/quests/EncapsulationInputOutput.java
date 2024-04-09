package quests;

import java.util.Scanner;
import java.util.Optional;

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

            Optional<String> divisionResult = calculations.divide();
            if (!divisionResult.isPresent()) {
                System.out.println("Error!");
            } else {
                System.out.println("Division: " + divisionResult.get());
            }
        } 
        catch (Exception e) {
            
        } 
        finally {
            scanner.close();
        }
    }
}
