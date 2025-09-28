package main.java.Set.HashSet.University;

import java.util.Objects;

public class Student {
    private final String id;
    private final String name;
    private final double gpa;

    public Student(String id , String name , double gpa){
        if(id == null || name == null || gpa < 0 || gpa > 4){
            throw new IllegalArgumentException("Invalid credentials");
        }
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getGpa(){
        return gpa;
    }
    public String toString(){
        return id + " - " + name + "( Gpa : " + gpa + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Student student)) return false;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
