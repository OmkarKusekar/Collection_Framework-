package main.java.List.ArrayList.UniversityManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        try{
            students.add(new Student("Omkar",3.7));
            students.add(new Student("Sneha",3.6));
            students.add(new Student("Shubham",2.9));
            students.add(new Student("Bhagwat",3.4));
            students.add(new Student("Vishal",2.3));
            students.add(new Student("Shivani",3.2));
        } catch (IllegalArgumentException e ){
            System.err.println("Error : " + e.getMessage());
            return;
        }
        System.out.println("Original Students List : ");
        students.forEach(s -> System.out.println(s.getName() + " : " + s.getGpa()));

        // 1. Sort by GPA (ascending) using a separate Comparator class
        // Use case: Rank students for academic reports

        students.sort(new GpaAscendingComparator());
        System.out.println("\nSorted by Gpa (Ascending) ");
        students.forEach(s-> System.out.println(s.getName() + ":" + s.getGpa()));

        // comparing in descending order

        students.sort(new GpaDescendingComparator());
        System.out.println("\nSorted Gpa By (Descending)");
        students.forEach(s->System.out.println(s.getName() + " : " + s.getGpa()));


        // 3. Sort by name (alphabetically) using lambda expression
        // Use case: Generate an alphabetical class roster

        students.sort((s1,s2)->s1.getName().compareTo(s2.getName()));
        System.out.println("\nSorted by name (Alphabetical)");
//        students.forEach(s->System.out.println(s.getName() + " : " + s.getGpa()));

//        students.sort(Comparator.comparing(Student::getName));
//        System.out.println();
//        students.forEach(s->System.out.println(s.getName() + " : " + s.getGpa()));

        // Searching

        Student searchStudent = new Student("Shivani",3.2);
        System.out.println("\nStudent contains Shivani ? " + students.contains(searchStudent));

        System.out.println("\nSearching by index : " + students.get(2));

    }
}
class GpaAscendingComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getGpa(),s2.getGpa());
    }
}

class GpaDescendingComparator implements Comparator<Student>{
    public int compare(Student s1 , Student s2){
        return Double.compare(s2.getGpa(), s1.getGpa());
    }
}
