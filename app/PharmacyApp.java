package app;

import models.*;
import system.MedicationTrackingSystem;

public class PharmacyApp {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();

        // Create sample data
        Doctor doctor = new Doctor("D001", "Dr. Smith", 45, "555-1234", "Cardiology");
        Patient patient = new Patient("P001", "John Doe", 30, "555-5678");
        Medication med = new Medication("M001", "Atorvastatin", "20mg", 50);

        // Add to system
        system.addDoctor(doctor);
        system.addPatient(patient);
        system.addMedication(med);

        // --- BEFORE EDIT ---
        System.out.println("\nBefore Edits:");
        System.out.println(doctor);
        System.out.println(patient);
        System.out.println(med);

        // --- EDIT ---
        system.editDoctor("D001", "Dr. Emily Smith", 46, "555-9876", "Neurology");
        system.editPatient("P001", "Jonathan Doe", 31, "555-0000");
        system.editMedication("M001", "Lipitor", "40mg", 100);

        // --- AFTER EDIT ---
        System.out.println("\nAfter Edits:");
        System.out.println(system.searchDoctorByName("Dr. Emily Smith"));
        System.out.println(system.searchPatientByName("Jonathan Doe"));
        System.out.println(system.searchMedicationByName("Lipitor"));

        // --- DELETE ---
        system.deleteDoctor("D001");
        system.deletePatient("P001");
        system.deleteMedication("M001");

        // --- CONFIRM DELETION ---
        System.out.println("\nAfter Deletion:");
        System.out.println("Doctor found? " + (system.searchDoctorByName("Dr. Emily Smith") != null));
        System.out.println("Patient found? " + (system.searchPatientByName("Jonathan Doe") != null));
        System.out.println("Medication found? " + (system.searchMedicationByName("Lipitor") != null));


        // --- ADD AN EXPIRED MEDICATION ---
Medication expiredMed = new Medication("M002", "Old Antibiotic", "250mg", 10);
expiredMed.setExpiryDate(java.time.LocalDate.now().minusDays(30)); // force it to be expired
system.addMedication(expiredMed);

// --- EXPIRED MEDS REPORT ---
system.generateExpiredMedicationsReport();

// Issue another prescription to test
Doctor newDoc = new Doctor("D002", "Dr. Jones", 50, "555-2222", "Oncology");
Patient newPatient = new Patient("P002", "Sarah Lee", 28, "555-4444");
Medication newMed = new Medication("M003", "Tamoxifen", "10mg", 40);

system.addDoctor(newDoc);
system.addPatient(newPatient);
system.addMedication(newMed);

system.acceptPrescription("Dr. Jones", "Sarah Lee", "Tamoxifen");

// Generate report
system.printPrescriptionsByDoctor("Dr. Jones");

// --- PATIENT PRESCRIPTION SUMMARY REPORT ---
system.printPatientPrescriptionSummary("Sarah Lee");
    }
  
}