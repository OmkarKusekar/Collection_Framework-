package main.java.List.Stack;

import java.util.Stack;
//Every time you type something, it’s pushed onto a stack.
//When you hit Undo, the last action is popped off.

public class UndoExample {
    public static void main(String[] args) {
        Stack<String> actions = new Stack<>();

        actions.push("Typed A");
        actions.push("Typed B");
        actions.push("Delete c");

        System.out.println("undo : " + actions.pop());
        System.out.println("undo : " + actions.pop());



    }
}
