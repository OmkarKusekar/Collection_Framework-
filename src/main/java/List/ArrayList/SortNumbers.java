package main.java.List.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <10 ; i++) {
            number.add(random.nextInt(100));

        }
        System.out.println("Original List:"+number);

        Collections.sort(number);
        System.out.println("After Sorting :"+number);
    }
}
