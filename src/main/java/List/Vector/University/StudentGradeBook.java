package main.java.List.Vector.University;

import main.java.List.Vector.University.Student;

import java.util.Comparator;
import java.util.Enumeration;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StudentGradeBook {
    public static void main(String[] args) {
        Vector<Student> gradeBook = new Vector<>();
        try{
            gradeBook.add(new Student("Yash",3.2));
            gradeBook.add(new Student("Vishal",3.0));
            gradeBook.add(new Student("Shivani",2.4));
            gradeBook.add(new Student("Vikas",3.7));
            gradeBook.add(1,new Student("Shubham",3.1));

            Vector<Student> newStudent = new Vector<>();
            newStudent.add(new Student("Omkar",3.5));
            newStudent.add(new Student("Sneha",3.9));
            gradeBook.addAll(newStudent);

            System.out.println("Initial gradeBook : " + gradeBook);



        }catch(IllegalArgumentException e ){
            System.out.println("Error : " + e.getMessage());
        }
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Reader thread: Iterate using Enumeration
        executor.submit(() -> {
            System.out.println("\nReader Thread: Gradebook (using Enumeration):");
            Enumeration<Student> enumeration = gradeBook.elements();
            while (enumeration.hasMoreElements()) {
                System.out.println(enumeration.nextElement());
                try {
                    Thread.sleep(100); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Writer thread: Add a student
        executor.submit(() -> {
            try {
                Thread.sleep(50); // Delay to overlap with reader
                gradeBook.addElement(new Student("Neha", 3.9));
                System.out.println("\nWriter Thread: Added Neha");
            } catch (Exception e) {
                System.err.println("Writer Error: " + e.getMessage());
            }
        });

        // Writer thread: Remove a student
        executor.submit(() -> {
            try {
                Thread.sleep(75); // Delay to overlap with reader
                gradeBook.removeElement(new Student("Vikas", 2.2));
                System.out.println("\nWriter Thread: Removed Vikas");
            } catch (Exception e) {
                System.err.println("Writer Error: " + e.getMessage());
            }
        });

        // Shutdown executor and wait
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nGradebook after concurrent modifications: " + gradeBook);

        // 3. Sorting with Comparator
        // Sort by GPA (descending)
        // Use case: Rank students for awards
        gradeBook.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("\nSorted by GPA (descending):");
        gradeBook.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));

        // Sort by name
        // Use case: Generate alphabetical gradebook
        gradeBook.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted by name:");
        gradeBook.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));

        // 4. Vector-specific methods
        // capacity(): Current capacity
        System.out.println("\nVector capacity: " + gradeBook.capacity());

        // ensureCapacity(int minCapacity): Increase capacity if needed
        gradeBook.ensureCapacity(20);
        System.out.println("Capacity after ensureCapacity(20): " + gradeBook.capacity());

        // trimToSize(): Reduce capacity to size
        gradeBook.trimToSize();
        System.out.println("Capacity after trimToSize: " + gradeBook.capacity());

        // setSize(int newSize): Set size (truncate or pad with null)
        gradeBook.setSize(5); // Truncate to 5 students
        System.out.println("Gradebook after setSize(5): " + gradeBook);

        // elementAt(int index): Get student at index
        System.out.println("Student at index 0: " + gradeBook.elementAt(0));

        // firstElement() / lastElement(): Access first/last student
        System.out.println("First student: " + gradeBook.firstElement());
        System.out.println("Last student: " + gradeBook.lastElement());

        // removeElementAt(int index): Remove by index
        gradeBook.removeElementAt(4); // Remove last element (null or student)
        System.out.println("After removing element at index 4: " + gradeBook);

        // removeAllElements(): Clear all elements
        Vector<Student> backup = new Vector<>(gradeBook);
        gradeBook.removeAllElements();
        System.out.println("After removeAllElements: " + gradeBook);

        // Restore gradebook
        gradeBook.addAll(backup);
        System.out.println("Restored gradebook: " + gradeBook);

        // 5. Other List methods
        // contains(Object o): Check if student exists
        System.out.println("\nContains Neha? " + gradeBook.contains(new Student("Neha", 3.9)));

        // indexOf(Object o): Find position
        System.out.println("Index of Amol: " + gradeBook.indexOf(new Student("Amol", 3.8)));

        // subList(int fromIndex, int toIndex): Get sublist
        System.out.println("Sublist (0 to 2): " + gradeBook.subList(0, 2));

        // toArray() / toArray(T[] a): Convert to array
        Student[] gradeBookArray = gradeBook.toArray(new Student[0]);
        System.out.println("GradeBook as array: " + java.util.Arrays.toString(gradeBookArray));

        // stream(): Filter high-GPA students
        System.out.println("\nHigh-GPA students (>3.0):");
        gradeBook.stream()
                .filter(s -> s.getGpa() > 3.0)
                .forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));
    }



}
