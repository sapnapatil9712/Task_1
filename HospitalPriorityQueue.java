import java.util.*;
import java.io.*;

public class HospitalPriorityQueue {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        hospital.addPatient("Alice", 2);
        hospital.addPatient("Bob", 1);
        hospital.addPatient("Charlie", 3);

        System.out.println("Before attending patients:");
        hospital.displayPatients();

        System.out.println("\nAttending patients:");
        hospital.attendPatient();
        hospital.attendPatient();
        hospital.attendPatient();
        hospital.attendPatient();
    }
}

class Patient {
    String name;
    int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String toString() {
        return "Patient{name='" + name + "', priority=" + priority + "}";
    }
}

class Hospital {
    private PriorityQueue<Patient> patientQueue;

    public Hospital() {
        patientQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));
    }

    public void addPatient(String name, int priority) {
        patientQueue.offer(new Patient(name, priority));
    }

    public void attendPatient() {
        if (!patientQueue.isEmpty()) {
            System.out.println("Attending: " + patientQueue.poll());
        } else {
            System.out.println("No patients in queue.");
        }
    }

    public void displayPatients() {
        System.out.println("Current patients in queue: " + patientQueue);
    }
}
