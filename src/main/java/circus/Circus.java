package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("number of animals in Circus: " + animals.length);
//        animals[3] = new Duck("Louie"); // not work because array is fixed length.
//        makeAnimalsTalk();
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals)); //cast array to arraylist

        Elephant strongOne = new Elephant("StrongOne");
        Parrot andy = new Parrot("andy");

        animalArrayList.add(new Duck("Louie"));
        animalArrayList.add(strongOne);
        animalArrayList.add(andy);

        System.out.println("before sorting ...");

        printAllAnimals(animalArrayList);
        printNumberOfAnimals(animalArrayList);

        System.out.println("after sorting ...");

        animalArrayList.sort(Animal.AnimalNameComparator);
        printAllAnimals(animalArrayList);

        System.out.println("Strong One is at position " + animalArrayList.indexOf(strongOne));

//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }

    private static void printNumberOfAnimals(ArrayList<Animal> animalArrayList) {
        System.out.println("Number of animals in Circus: " + animalArrayList.size());
    }


    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }
}
