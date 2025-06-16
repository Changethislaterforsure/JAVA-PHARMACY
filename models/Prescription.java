package models;

import java.time.LocalDate;

/**
 * Represents a prescription issued by a doctor for a patient and medication.
 */
public class Prescription {

    private String id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    /**
     * Constructs a new Prescription with the current date as the issue date
     * and an expiry date one year later.
     *
     * @param id         the unique prescription ID
     * @param doctor     the prescribing doctor
     * @param patient    the receiving patient
     * @param medication the medication being prescribed
     */
    public Prescription(String id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now();
        this.expiryDate = issueDate.plusYears(1);
    }

    public String getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Checks whether the prescription is still valid (not expired).
     *
     * @return true if current date is before the expiry date
     */
    public boolean isValid() {
        return LocalDate.now().isBefore(expiryDate);
    }

    /**
     * Returns a string representation of the prescription.
     *
     * @return formatted string with prescription details
     */
    @Override
    public String toString() {
        return "Prescription [ID: " + id +
               ", Doctor: " + doctor.getName() +
               ", Patient: " + patient.getName() +
               ", Medication: " + medication.getName() +
               ", Issued: " + issueDate +
               ", Expires: " + expiryDate + "]";
    }
}