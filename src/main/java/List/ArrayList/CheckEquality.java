package main.java.List.ArrayList;

import java.util.ArrayList;

public class CheckEquality {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();


        list1.add("Mango");
        list1.add("Banana");
        list1.add("Orange");

        list2.add("Mango");
        list2.add("Banana");
        list2.add("Orange");

        // Check equality before modification

        System.out.println("Lists equal before modefication ? " + list1.equals(list2));

        list1.add("Apple");

        // Check equality after modification

        System.out.println("List equal after modification : " + list1.equals(list2));



    }
}
