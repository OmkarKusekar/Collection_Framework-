package main.java.List.LinkedList.StudentWaitListSystem;

public class Student {
    private String name;
    private double gpa;

    public Student(String name , double gpa ){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("name cannot be null");
        }
        if(gpa < 0 || gpa > 4 ){
            throw new IllegalArgumentException("gpa should be in between 0 to 4 ");
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

    public String toString(){
        return "Student{ name = '" + name +"' ,gpa = " + gpa +"}";
    }
}
