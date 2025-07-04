package system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import models.*;

/**
 * Central system to manage medications, doctors, patients, and prescriptions.
 */
public class MedicationTrackingSystem {

    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    /**
     * Initializes empty system lists.
     */
    public MedicationTrackingSystem() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // ---------- ADD METHODS ----------

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // ---------- SEARCH METHODS ----------

    public Doctor searchDoctorByName(String name) {
        return doctors.stream()
                      .filter(d -> d.getName().equalsIgnoreCase(name))
                      .findFirst()
                      .orElse(null);
    }

    public Patient searchPatientByName(String name) {
        return patients.stream()
                       .filter(p -> p.getName().equalsIgnoreCase(name))
                       .findFirst()
                       .orElse(null);
    }

    public Medication searchMedicationByName(String name) {
        return medications.stream()
                          .filter(m -> m.getName().equalsIgnoreCase(name))
                          .findFirst()
                          .orElse(null);
    }
    /**
 * Accepts a new prescription by linking a doctor, patient, and medication.
 *
 * @param doctorName    the name of the prescribing doctor
 * @param patientName   the name of the patient receiving the prescription
 * @param medicationName the name of the prescribed medication
 * @return the created Prescription, or null if any entity wasn't found
 */
public Prescription acceptPrescription(String doctorName, String patientName, String medicationName) {
    Doctor doctor = searchDoctorByName(doctorName);
    Patient patient = searchPatientByName(patientName);
    Medication medication = searchMedicationByName(medicationName);

    if (doctor == null || patient == null || medication == null) {
        System.out.println("Error: One or more entities not found.");
        return null;
    }

    // Generate a unique prescription ID
    String prescriptionId = "RX-" + UUID.randomUUID().toString().substring(0, 8);

    // Create prescription
    Prescription prescription = new Prescription(prescriptionId, doctor, patient, medication);

    // Add to system and patient
    prescriptions.add(prescription);
    patient.addPrescription(prescription);
    patient.addMedication(medication);
    doctor.addPatient(patient); // optional: if not already added

    System.out.println("Prescription accepted and recorded successfully.");
    return prescription;
}
public boolean editPatient(String id, String newName, int newAge, String newPhone) {
    for (Patient patient : patients) {
        if (patient.getId().equals(id)) {
            patient.setName(newName);
            patient.setAge(newAge);
            patient.setPhoneNumber(newPhone);
            System.out.println("Patient updated.");
            return true;
        }
    }
    System.out.println("Patient not found.");
    return false;
}

public boolean deletePatient(String id) {
    return patients.removeIf(patient -> patient.getId().equals(id));
}
public boolean editDoctor(String id, String newName, int newAge, String newPhone, String newSpecialization) {
    for (Doctor doctor : doctors) {
        if (doctor.getId().equals(id)) {
            doctor.setName(newName);
            doctor.setAge(newAge);
            doctor.setPhoneNumber(newPhone);
            doctor.setSpecialization(newSpecialization);
            System.out.println("Doctor updated.");
            return true;
        }
    }
    System.out.println("Doctor not found.");
    return false;
}

public boolean deleteDoctor(String id) {
    return doctors.removeIf(doctor -> doctor.getId().equals(id));
}
public boolean editMedication(String id, String newName, String newDose, int newStock) {
    for (Medication med : medications) {
        if (med.getId().equals(id)) {
            med.setName(newName);
            med.setDose(newDose);
            med.setQuantityInStock(newStock);
            System.out.println("Medication updated.");
            return true;
        }
    }
    System.out.println("Medication not found.");
    return false;
}

public boolean deleteMedication(String id) {
    return medications.removeIf(med -> med.getId().equals(id));
}
/**
 * Prints a report of all expired medications in the system.
 */
public void generateExpiredMedicationsReport() {
    System.out.println("\n--- Expired Medications Report ---");
    boolean found = false;

    for (Medication med : medications) {
        if (med.isExpired()) {
            System.out.println(med);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No expired medications found.");
    }
}
/**
 * Prints all prescriptions issued by a specific doctor.
 *
 * @param doctorName the name of the doctor to search for
 */
public void printPrescriptionsByDoctor(String doctorName) {
    System.out.println("\n--- Prescriptions Issued by Dr. " + doctorName + " ---");
    boolean found = false;

    for (Prescription p : prescriptions) {
        if (p.getDoctor().getName().equalsIgnoreCase(doctorName)) {
            System.out.println(p);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No prescriptions found for that doctor.");
    }
}
/**
 * Prints a summary of prescriptions for a given patient from the past year.
 *
 * @param patientName the name of the patient
 */
public void printPatientPrescriptionSummary(String patientName) {
    System.out.println("\n--- Prescription Summary for " + patientName + " (Past Year) ---");
    Patient patient = searchPatientByName(patientName);

    if (patient == null) {
        System.out.println("Patient not found.");
        return;
    }

    LocalDate oneYearAgo = LocalDate.now().minusYears(1);
    boolean found = false;

    for (Prescription p : prescriptions) {
        if (p.getPatient().equals(patient) && p.getIssueDate().isAfter(oneYearAgo)) {
            System.out.println("- " + p.getMedication().getName());
            found = true;
        }
    }

    if (!found) {
        System.out.println("No prescriptions found in the past year.");
    }
}

/**
 * Restocks all medications to a fixed stock level.
 *
 * @param targetQuantity the desired stock level to reset to
 */
public void restockMedicationsToLevel(int targetQuantity) {
    System.out.println("\n--- Restocking Medications to Set Level (" + targetQuantity + ") ---");

    for (Medication med : medications) {
        med.setQuantityInStock(targetQuantity);
        System.out.println(med.getName() + ": Set to " + targetQuantity);
    }
}

    // ---------- GETTERS ----------

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
}