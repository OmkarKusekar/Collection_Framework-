package main.java.List.Vector;

import java.util.Vector;

class Patient {
    private final String name;
    private final String department;

    public Patient(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name + " - " + department;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Vector<Patient> admittedPatients = new Vector<>();

        // Add patients
        admittedPatients.add(new Patient("Akash", "Emergency"));
        admittedPatients.add(new Patient("Balu", "Cardiology"));
        admittedPatients.add(new Patient("Charu", "Orthopedics"));

        // Nurse thread adds a new patient
        new Thread(() -> {
            admittedPatients.add(new Patient("Dyana", "Neurology"));
            System.out.println("Nurse added Dyana");
        }).start();

        // Billing thread removes a patient
        new Thread(() -> {
            admittedPatients.remove(1);
            System.out.println("Billing removed patient at index 1");
        }).start();


        new Thread(() -> {
            System.out.println("Admin reading patients:");
            admittedPatients.forEach(System.out::println);
        }).start();
    }
}
