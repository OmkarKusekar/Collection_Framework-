package main.java.Set.HashSet;

import java.util.HashSet;

public class Example {
    public static void main(String[] args) {
        HashSet<String> subscribers = new HashSet<>();
        subscribers.add("a@gmail.com");
        subscribers.add("b@gmail.com");
        subscribers.add("c@gmail.com");
        subscribers.add("b@gmail.com"); // duplicates ignored

        System.out.println("Subscribers : " + subscribers);
    }

}
