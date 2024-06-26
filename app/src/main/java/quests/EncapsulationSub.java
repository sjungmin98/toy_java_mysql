package quests;

import java.util.Optional;

public class EncapsulationSub {
    private int firstNumber;
    private int secondNumber;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int add() {
        try {
            return this.firstNumber + this.secondNumber;
        } 
        catch (Exception e) {

        }
        return 0; 
    }

    public int subtract() {
        try {
            return this.firstNumber - this.secondNumber;
        } 
        catch (Exception e) {

        }
        return 0;
    }

    public int multiply() {
        try {
            return this.firstNumber * this.secondNumber;
        } 
        catch (Exception e) {

        }
        return 0;
    }

    public Optional<String> divide() {
        if (this.secondNumber == 0) {
            return Optional.empty();
        }
        int divisionResult = this.firstNumber / this.secondNumber;
        int remainder = this.firstNumber % this.secondNumber;
        return Optional.of(String.format("[%d / %d]", divisionResult, remainder));
    }
}
