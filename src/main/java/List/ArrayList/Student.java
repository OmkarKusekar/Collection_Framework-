package main.java.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
   private double gpa;

    public Student(String name , double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static void main(String[] args) {

        List<Student> Students = new ArrayList<>();
        Students.add(new Student("Omkar",4.3));
        Students.add(new Student("Amol",4.8));
        Students.add(new Student("Vikas",2.2));
        Students.add(new Student("Vishal",3.2));
        Students.add(new Student("Shubham",2.7));
        Students.sort((a,b)-> (int) (a.getGpa() - b.getGpa()));
        for(Student s : Students){
            System.out.println(s.getName()+ ":"+ s.getGpa());
        }


    }
}
