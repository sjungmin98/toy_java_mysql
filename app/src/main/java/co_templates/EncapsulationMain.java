package co_templates;

public class EncapsulationMain {
    public static void main(String[] args) {
        EncapsulationAnimal animal = new EncapsulationAnimal();
        animal.animalSound();
        // animal.byPass(4, 5);
        // System.out.println("animal.firstNum : "+animal.firstNum);
        // System.out.println("animal.secondNum : "+animal.secondNum);
        // System.out.println("animal.result : "+animal.result);
        animal.setresult(6);
        System.out.println("animal.getResult() : "+animal.getResult());
        // System.out.println("animal.result ++ : "+(++animal.result));
        return ;
    }
}
