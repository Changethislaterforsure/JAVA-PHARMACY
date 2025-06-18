package system;

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