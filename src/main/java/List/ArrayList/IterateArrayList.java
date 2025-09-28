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
        for(String Animal : AnimalsArray){
            System.out.println(Animal);
        }

        // Reverse
        Collections.reverse(animals);

        System.out.println("Reversed List " + animals);

        System.out.println(" Using loop : ");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }


        System.out.println("\nUsing for each loop : ");
        for(String Animals : animals){
            System.out.println(Animals);
        }

        System.out.println("\nUsing Iterator");
        Iterator<String> iterator = animals.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\nUsing ListIterator");
        ListIterator<String> listIterator = animals.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

    }

}
