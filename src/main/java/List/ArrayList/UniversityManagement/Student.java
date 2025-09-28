package main.java.List.ArrayList.UniversityManagement;

import java.util.Objects;

public class Student {
    private String name;
    private double gpa;

    public Student(String name , double gpa){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty ");
        }
        if(gpa < 0.0 || gpa > 4.0){
            throw new IllegalArgumentException(" gpa must be between 0 to 4");
        }
        this.name = name;
        this.gpa = gpa;
    }

    public String getName(){
        return name;
    }
    public double getGpa(){
        return gpa;
    }
    @Override
    public String toString(){
        return "Student{ name ='" +name +"' ,gpa = " + gpa + "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }
}
