package app;

import models.*;
import system.MedicationTrackingSystem;

public class PharmacyApp {
    public static void main(String[] args) {
        // Step 1: Create the system
        MedicationTrackingSystem system = new MedicationTrackingSystem();

        // Step 2: Create test data
        Doctor doctor = new Doctor("D001", "Dr. Smith", 45, "555-1234", "Cardiology");
        Patient patient = new Patient("P001", "John Doe", 30, "555-5678");
        Medication med = new Medication("M001", "Atorvastatin", "20mg", 50);

        // Step 3: Add to system
        system.addDoctor(doctor);
        system.addPatient(patient);
        system.addMedication(med);

        // Step 4: Accept a prescription
        Prescription prescription = system.acceptPrescription("Dr. Smith", "John Doe", "Atorvastatin");

        // Step 5: Print the result
        if (prescription != null) {
            System.out.println("\nPrescription created:");
            System.out.println(prescription);
        } else {
            System.out.println("Prescription failed.");
        }
    }
}