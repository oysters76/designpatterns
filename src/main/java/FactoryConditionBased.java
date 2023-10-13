import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FactoryConditionBased {

    public static void main(String[] args) {

        ConditionBasedAnimalFactory animalFactory =
                new FactoryConditionBased().new ConditionBasedAnimalFactory();

        animalFactory.addCondition(5, ConditionBasedAnimalFactory.I_DOG);
        animalFactory.addCondition(10, ConditionBasedAnimalFactory.I_DUCK);
        animalFactory.addCondition(8, ConditionBasedAnimalFactory.I_CAT);

        for (int i = 1; i <= 100; i++)
        {
            ArrayList<Animal> animals = animalFactory.makeMultipleAnimals("foo", "bar", i);
            if (animals.isEmpty())
                continue;
            System.out.println("Found " + animals.size() + " animals at iteration: "+i+"!");
            for (Animal animal : animals){
                animal.shout();
                animal.speak();
            }
            System.out.println("-----------------------------------");
        }


    }


    interface AnimalFactory{
        public Animal makeAnimal(String name, String sound, int iteration);
        public ArrayList<Animal> makeMultipleAnimals(String name, String sound, int iteration);
    }

    class ConditionBasedAnimalFactory implements AnimalFactory{

        public final static int I_DOG = 0;
        public final static int I_CAT = 1;
        public final static int I_DUCK = 2;

        private HashMap<Integer, Integer> conditions = new HashMap<>();

        public void addCondition(int value, int type){
            conditions.put(value, type);
        }

        private int getValueFromConditions(int value){
            for (Integer key : conditions.keySet()) {
                if ((value % key) == 0)
                    return key;
            }
            return -1;
        }

        private ArrayList<Integer> getMultipleValuesFromConditions(int value){
            ArrayList<Integer> matchingValues = new ArrayList<>();
            for (Integer key : conditions.keySet()){
                if((value % key) == 0)
                    matchingValues.add(key);
            }
            return matchingValues;
        }

        private Animal makeAnimalFromType(String name, String sound, int val){
            switch (conditions.get(val)){
                case I_DOG -> {
                    return new Dog(name, sound);
                }
                case I_CAT -> {
                    return new Cat(name, sound);
                }
                case I_DUCK -> {
                    return new Duck(name, sound);
                }
            }
            return null;
        }

        @Override
        public Animal makeAnimal(String name, String sound, int value) {
            int val = getValueFromConditions(value);
            if (val == -1)
                return null;
            return makeAnimalFromType(name, sound, val);
        }

        @Override
        public ArrayList<Animal> makeMultipleAnimals(String name, String sound, int iteration) {
            ArrayList<Integer> values = getMultipleValuesFromConditions(iteration);
            ArrayList<Animal> animals = new ArrayList<>();
            for (Integer val : values){
                animals.add(makeAnimal(name, sound, val));
            }
            return animals;
        }
    }

    interface AnimalBehavior{
        public void speak();
        public void shout();
    }

    abstract class Animal implements AnimalBehavior{
        private String name;
        private String sound;

        public Animal(String name, String sound){
            this.name = name;
            this.sound = sound;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

    }

    class Cat extends Animal{

        public Cat(String name, String sound) {
            super(name, sound);
        }

        @Override
        public void speak() {
            System.out.println("meow");
        }

        @Override
        public void shout() {
            System.out.println("MEOW!");
        }
    }

    class Dog extends Animal{

        public Dog(String name, String sound) {
            super(name, sound);
        }

        @Override
        public void speak() {
            System.out.println("woof!");
        }

        @Override
        public void shout() {
            System.out.println("WOOF!");
        }
    }

    class Duck extends Animal{

        public Duck(String name, String sound) {
            super(name, sound);
        }

        @Override
        public void speak() {
            System.out.println("bbr");
        }

        @Override
        public void shout() {
            System.out.println("BRR");
        }
    }

}
