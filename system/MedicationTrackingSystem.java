package system;

import models.*;

import java.util.ArrayList;
import java.util.List;

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