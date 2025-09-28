package main.java.Set.TreeSet;

import java.util.TreeSet;
// sorted
public class Example {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(34);
        scores.add(56);
        scores.add(96);
        scores.add(77);
        scores.add(69);

        System.out.println(scores);
        System.out.println("Highest score : " + scores.last());
        System.out.println("Lowest score : " + scores.first());
    }
}
