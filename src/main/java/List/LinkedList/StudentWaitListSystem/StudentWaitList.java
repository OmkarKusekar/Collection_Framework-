package main.java.List.LinkedList.StudentWaitListSystem;

import java.util.Comparator;
import java.util.LinkedList;

public class StudentWaitList {
    public static void main(String[] args) {
        LinkedList<Student> waitList = new LinkedList<>();
        try{
            waitList.add(new Student("Omkar",3.2));

            waitList.add(new Student("Tejesh",3.7));

            waitList.addFirst(new Student("Ram",2.9));

            waitList.addLast(new Student("Karan",2.4));

            waitList.add(1,new Student("Amol",2.4));

        }catch(IllegalArgumentException e){
            System.err.println("Error : " + e.getMessage());
            return;
        }

        System.out.println("Initial List ");
        waitList.forEach(s->System.out.println(s.getName() + " : " + s.getGpa()));

        // Sorting with Comparator (Ascending order )
        waitList.sort(new GpaAscendingComparator());
        System.out.println("\nSorted GPA by (Ascending)");
        waitList.forEach(s-> System.out.println(s.getName() + ":" + s.getGpa()));

        // sorting with lambda

        waitList.sort((s1,s2)->Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("\nSorted Gpa by descending : ");
        waitList.forEach(s->System.out.println(s.getName()+ ":" + s.getGpa()));

        // Sort by name using Comparator.comparing

        waitList.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted by name ");
        waitList.forEach(s->System.out.println(s.getName() + ":" + s.getGpa()));

        // sort gpa and then name

        waitList.sort(Comparator.comparingDouble(Student::getGpa)
                .thenComparing(Student::getName));
        System.out.println("\nSorted by gpa and then name ");
        waitList.forEach(s->System.out.println(s.getName() + ":" + s.getGpa()));

        Student removed = waitList.remove();
        System.out.println("removed from waitList : " + removed);

        removed = waitList.removeLast();
        System.out.println(removed);



        //System.out.println(waitList.getFirst());
        System.out.println(waitList.getLast());

        System.out.println(waitList.peek());

        System.out.println(waitList.poll());

        System.out.println(waitList);



        
    }
    
}
class GpaAscendingComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1 , Student s2 ){
        return Double.compare(s1.getGpa(), s2.getGpa());
    }
}