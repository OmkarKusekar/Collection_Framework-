package main.java.List.ArrayList;

import java.util.ArrayList;

public class RemoveCondition {
    public static void main(String[] args) {
        ArrayList <Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);
        numbers.add(80);
        numbers.add(90);
        numbers.add(95);

        System.out.println("Original Numbers: "+numbers);

        numbers.removeIf(n-> n > 50);

        System.out.println("After removing numbers which are grater than 50: "+numbers);

    }

}
