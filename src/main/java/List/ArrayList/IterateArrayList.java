package main.java.List.ArrayList;


import java.util.*;

public class IterateArrayList {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        animals.add("Cow");
        animals.add("Sheep");
        animals.add("Goat");

        String[] AnimalsArray = animals.toArray(new String[0]);
        for (String Animal : AnimalsArray) {
            System.out.println(Animal);
        }

        // Reverse
        Collections.reverse(animals);

        System.out.println("Reversed List " + animals);

        System.out.println(" Using loop : ");
        for (String s : animals) {
            System.out.println(s);
        }


        System.out.println("\nUsing for each loop : ");
        for (String Animals : animals) {
            System.out.println(Animals);
        }

        System.out.println("\nUsing Iterator");
        for (String s : animals) {
            System.out.println(s);
        }

        System.out.println("\nUsing ListIterator");
        for (String animal : animals) {
            System.out.println(animal);
        }

    }
}


