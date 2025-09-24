package main.java.List.Stack.University;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class StudentApplication {

    public static void main(String[] args) {
        Stack<Student> applicationStack = new Stack<>();
        Stack<Student> undoStack = new Stack<>();

        LinkedList<Student> dequeStack = new LinkedList<>();

        try{
            applicationStack.push(new Student("Omkar",3.3));
            applicationStack.push(new Student("Neha",3.9));
            applicationStack.push(new Student("Sahil",2.6));
            applicationStack.push(new Student("Ram",2.9));
            applicationStack.push(new Student("Shyam",2.3));

            dequeStack.push(new Student("Omkar",3.3));
            dequeStack.push(new Student("Neha",3.9));
            dequeStack.push(new Student("Sahil",2.6));
            dequeStack.push(new Student("Ram",2.9));
            dequeStack.push(new Student("Shyam",2.3));
        }catch(IllegalArgumentException e){
            System.out.println("Error : " + e.getMessage());
        }

        // print stack
        System.out.println("Application Stack : " + applicationStack);
        System.out.println("Deque Stack : " + dequeStack);

        // Stack Operations

        System.out.println("\nLatest Application : " + applicationStack.peek());
        System.out.println("Latest Application (Deque peek) : " + dequeStack.peek());

        // Remove the top element

        Student processed = applicationStack.pop();
        undoStack.push(processed);
        System.out.println("Processed (popped) from Stack: " + processed);

        System.out.println("stack after pop " + applicationStack);

        processed = dequeStack.pop();
        System.out.println("Processed (popped) from Deque: " + processed);
        System.out.println("Deque after pop: " + dequeStack);

        System.out.println( " \nis ApplicationStack empty ? "+ applicationStack.empty());
        System.out.println( "is deque empty ?  " + dequeStack.isEmpty());


        // search(Object o): Find position of a student (1-based from top)
        Student searchStudent = new Student("Amol", 3.8);
        int position = applicationStack.search(searchStudent);
        System.out.println("Position of Amol in Stack (1-based): " + position);

        // 3. Undo operation
        // Restore last processed student from undo stack
        if (!undoStack.empty()) {
            Student undone = undoStack.pop();
            applicationStack.push(undone);
            System.out.println("\nUndid processing of: " + undone);
            System.out.println("Stack after undo: " + applicationStack);
        }

        // 4. Sorting with Comparator (convert to ArrayList for sorting)
        // Use case: Generate a ranked report of applications
        ArrayList<Student> sortedList = new ArrayList<>(applicationStack);

        // Sort by GPA (descending)
        sortedList.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("\nSorted by GPA (descending):");
        sortedList.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));

        // Sort by name
        sortedList.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted by name:");
        sortedList.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));

        // 5. Other ArrayList methods for reporting
        // contains(Object o): Check if a student applied
        System.out.println("\nContains Vikas? " + sortedList.contains(new Student("Vikas", 2.2)));

        // get(int index): Get top-ranked student
        System.out.println("Top-ranked student: " + sortedList.getFirst());

        // toArray(): Export for reporting
        Student[] reportArray = sortedList.toArray(new Student[0]);
        System.out.println("Applications as array: " + java.util.Arrays.toString(reportArray));

        // stream(): Filter high-GPA students
        System.out.println("\nHigh-GPA students (>3.0):");
        sortedList.stream()
                .filter(s -> s.getGpa() > 3.0)
                .forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));





    }
}
