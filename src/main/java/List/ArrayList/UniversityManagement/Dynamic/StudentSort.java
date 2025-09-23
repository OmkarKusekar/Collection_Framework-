package main.java.ArrayList.UniversityManagement.Dynamic;

import main.java.ArrayList.UniversityManagement.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSort {
    public static void sortStudents(List<Student> students, String criterion) {
        Comparator<Student> comparator = switch (criterion.toLowerCase()) {
            case "gpa" -> Comparator.comparingDouble(Student::getGpa);
            case "name" -> Comparator.comparing(Student::getName);
            case "namelength" -> (s1, s2) -> Integer.compare(s1.getName().length(), s2.getName().length());
            default -> throw new IllegalArgumentException("Invalid criterion: " + criterion);
        };
        students.sort(comparator);
    }

    public static void main(String[] args) {
        // Create ArrayList of Students
        List<Student> students = new ArrayList<>();
        try {
            students.add(new Student("Omkar", 3.3));
            students.add(new Student("Amol", 3.8));
            students.add(new Student("Vikas", 2.2));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        // Sort by different criteria
        System.out.println("Sort by GPA:");
        sortStudents(students, "gpa");
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));

        System.out.println("\nSort by name:");
        sortStudents(students, "name");
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));

        System.out.println("\nSort by name length:");
        sortStudents(students, "namelength");
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));
    }
}