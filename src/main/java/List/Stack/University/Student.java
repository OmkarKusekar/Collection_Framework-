package main.java.List.Stack.University;

public class Student {
    String name;
    double gpa;

    public Student(String name , double gpa ){

           if(name == null || name.trim().isEmpty()){
               throw new IllegalArgumentException("Name cannot be null or empty :");
           }
           if(gpa < 0 || gpa > 4 ){
               throw new IllegalArgumentException("Gpa should be in between 0 to 4 ");
           }
           this.name=name;
           this.gpa=gpa;

    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", gpa=" + gpa +  '}';

    }
}
