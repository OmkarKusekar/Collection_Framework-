package main.java.Set.HashSet.University;

import java.util.*;


public class ClubMembership {
    private static final HashSet<Student> members = new HashSet<>();
    private static final Stack<String> actionHistory = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("\n=== Club Membership Menu ===");
            System.out.println("1 Add Member");
            System.out.println("2 Remove Member");
            System.out.println("3 Check Membership");
            System.out.println("4 Show All Members ");
            System.out.println("5 Show Members sorted by gpa ");
            System.out.println("6 Show Members sorted by name");
            System.out.println("7 Show high gpa Members (gpa > 3.0)");
            System.out.println("8 Undo Last Action");
            System.out.println("9 Exit");
            System.out.print("Choose Option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> addMember(scanner);
                case 2 -> removeStudent(scanner);
                case 3 -> checkMembership(scanner);
                case 4 -> showAllMembers();
                case 5 -> showAllMemberSortByGpa();
                case 6 -> showAllMemberSortByName();
                case 7 -> showHighGpaMembers();
                case 8 -> undoLastAction();
                case 9 -> running = false;
                default -> System.out.println("Invalid choice ");

            }
        }
        scanner.close();
    }

    private static void addMember(Scanner scanner){
        System.out.println("Enter student Id : ");
        String id = scanner.nextLine();
        System.out.println("Enter student name : ");
        String name = scanner.nextLine();
        System.out.println("Enter gpa of student : ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

       try{
           Student student = new Student(id , name , gpa);
           if(members.add(student)){
               actionHistory.push("Added : " + student);
               System.out.println("Members added : " + student);
           }else {
               System.out.println("Student already a member");
           }

       }catch (IllegalArgumentException e){
           System.out.println("Error : " + e.getMessage());
       }

    }
    private static void removeStudent(Scanner scanner){
        System.out.println("Enter student id : ");
        String id = scanner.nextLine();
        Student student = members.stream()
                .filter(s->s.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(student != null && members.remove(student)){
            actionHistory.push("Removed : " + student);
            System.out.println("Member removed : " + student);
        }else{
            System.out.println("Student not found ");
        }
    }

    private static void checkMembership(Scanner scanner){
        System.out.println("Enter student id ");
        String id = scanner.nextLine();
        boolean isMember = members.stream().anyMatch(s->s.getId().equals(id));
        System.out.println(isMember ? "Student is member " : "Student is not member");
    }

    private static void showAllMembers(){
        System.out.println("\n----club member (hashSet) unsorted----");
        if(members.isEmpty()){
            System.out.println("No members ");
        }else{
            members.forEach(System.out::println);
        }
    }
    private static void showAllMemberSortByGpa(){
        System.out.println("\n----Members sorted by gpa (descending)---- ");
        if(members.isEmpty()){
            System.out.println("No members ");
            return;
        }
        List<Student> sorted = new ArrayList<>(members);
            sorted.sort(Comparator.comparingDouble(Student::getGpa).reversed());
            sorted.forEach(System.out::println);

    }
    private static void showAllMemberSortByName(){
        System.out.println("\n----Members sorted by name----");
        if(members.isEmpty()){
            System.out.println("No members ");
            return;
        }
        List<Student> sorted = new ArrayList<>(members);
        sorted.sort(Comparator.comparing(Student::getName));
        sorted.forEach(System.out::println);
    }
    private static void showHighGpaMembers(){
        System.out.println("\n----High Gpa members ( > 3.0 )----");
        List<Student> HighGpa = members.stream()
                .filter(s-> s.getGpa() > 3.0)
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .toList();
        if(HighGpa.isEmpty()){
            System.out.println("No high gpa members");
        }else{
            HighGpa.forEach(System.out::println);
        }

    }
    private static void undoLastAction(){
        if(actionHistory.isEmpty()){
            System.out.println("No actions to undo ");
            return;
        }
        String lastAction = actionHistory.pop();
        if(lastAction.startsWith("Added: ")){
            String[] parts = lastAction.split(" - ");
            String id = parts[0].replace("Added: ", "");
            members.removeIf(s -> s.getId().equals(id));
        }else if (lastAction.startsWith("Removed: ")) {
            String[] parts = lastAction.split(" - ");
            String id = parts[0].replace("Removed: ", "");
            String name = parts[1].split(" \\(GPA: ")[0];
            String gpaStr = parts[1].split(" \\(GPA: ")[1].replace(")", "");
            double gpa = Double.parseDouble(gpaStr);
            try {
                members.add(new Student(id, name, gpa));
            } catch (IllegalArgumentException e) {
                System.out.println(" Error restoring member: " + e.getMessage());
            }
        }
        System.out.println(" Undone: " + lastAction);
    }

    

}
