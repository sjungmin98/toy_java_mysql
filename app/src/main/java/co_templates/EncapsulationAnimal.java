package co_templates;

public class EncapsulationAnimal {
    public int firstNum;
    public int secondNum;
    private int result ;

    public void setresult(int number){
        this.result = number;
    }

    public int getResult(){
        return this.result;
    }

    public void animalSound() {
        System.out.println("The animal makes a sound");
    }

    public void byPass(int firstNumber, int secondNumber){
        this.firstNum = firstNumber;
        this.secondNum = secondNumber;
        this.result = firstNumber + secondNumber;
        // int result = firstNumber + secondNumber;
        return;
    }
}
