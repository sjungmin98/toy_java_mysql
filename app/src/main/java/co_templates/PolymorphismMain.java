package co_templates;

public class PolymorphismMain {
    public static void main(String[] args) {
        PolymorphismAnimal animal = new PolymorphismAnimal();
        animal.animalSound(); 
    
        PolymorphismAnimal pig = new PolymorphismPig();
        pig.animalSound(); 
    
        PolymorphismDog dog = new PolymorphismDog();
        dog.animalSound();
        dog.speed(3);
        return;
    }
}