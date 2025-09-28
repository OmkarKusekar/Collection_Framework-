package main.java.List.LinkedList;


import java.util.LinkedList;

public class Example {
    public static void main(String[] args) {
        LinkedList<String> task = new LinkedList<>();
        task.add("Wake up");
        task.add("Exercise and yoga ");
        task.add("Study Java ");
        task.add("Eat");

        task.addFirst("Brush Teeth");

        task.addLast("Rest ");
        System.out.println(task);

        task.remove("Rest ");

        for(String Task : task){
            System.out.println(Task);
        }
    }

}
