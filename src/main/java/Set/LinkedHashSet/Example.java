package main.java.Set.LinkedHashSet;

import java.util.LinkedHashSet;
// order matter
public class Example {
    public static void main(String[] args) {
        LinkedHashSet<String> browserHistory = new LinkedHashSet<>();
        browserHistory.add("Google");
        browserHistory.add("Youtube");
        browserHistory.add("Github");
        browserHistory.add("ChatGpt");
        browserHistory.add("Youtube");

        System.out.println("Browsing History : " + browserHistory);
    }
}
