package main.java.List.Stack.University;

import java.util.Comparator;
import java.util.LinkedList;

public class PriorityList {
    public static void addWithPriority(LinkedList<Student>waitlist,Student student,double gpaThreshold){
        if(student.getGpa() > gpaThreshold){
            waitlist.offerFirst(student);
        }
        else {
            waitlist.offerLast(student);
        }
    }

    public static void main(String[] args) {
        LinkedList<Student> waitlist = new LinkedList<>();
        double gpaThreshold = 3.5;

        try {
            addWithPriority(waitlist, new Student("Omkar", 3.8), gpaThreshold);
            addWithPriority(waitlist, new Student("Vikas", 3.2), gpaThreshold);
            addWithPriority(waitlist, new Student("Pallavi", 2.8), gpaThreshold);
            addWithPriority(waitlist, new Student("Mayur", 2.3), gpaThreshold);
            addWithPriority(waitlist, new Student("Akash", 3.6), gpaThreshold);
            addWithPriority(waitlist, new Student("Sneha", 3.2), gpaThreshold);


        } catch (IllegalArgumentException e) {
            System.err.println("Error : " + e.getMessage());
        }
        waitlist.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("Priority Waitlist (sorted by GPA descending):");
        waitlist.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));
    }
}
