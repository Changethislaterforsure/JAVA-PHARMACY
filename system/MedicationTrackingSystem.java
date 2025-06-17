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