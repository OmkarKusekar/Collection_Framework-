package main.java.List.Stack;

import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();
        history.push("Youtube");
        history.push("GitHub");
        history.push("IntellijIdea");
        history.push("Google");

        System.out.println("Back to : " + history.pop());
    }
}
