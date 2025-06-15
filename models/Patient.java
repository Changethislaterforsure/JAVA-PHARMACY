package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a patient in the pharmacy system.
 * Inherits common attributes from the Person class.
 */
public class Patient extends Person {

    /**
     * List of medications the patient is currently taking.
     */
    private List<Medication> medications;

    /**
     * List of active prescriptions associated with the patient.
     */
    private List<Prescription> prescriptions;

    /**
     * Constructs a new Patient with the given details.
     *
     * @param id          the patient's unique ID
     * @param name        the patient's name
     * @param age         the patient's age
     * @param phoneNumber the patient's phone number
     */
    public Patient(String id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Gets the list of medications the patient is taking.
     *
     * @return list of medications
     */
    public List<Medication> getMedications() {
        return medications;
    }

    /**
     * Adds a medication to the patient's list.
     *
     * @param medication the medication to add
     */
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Gets the list of prescriptions for the patient.
     *
     * @return list of prescriptions
     */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Adds a prescription to the patient's list.
     *
     * @param prescription the prescription to add
     */
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Returns a string representation of the patient.
     *
     * @return formatted string with patient details
     */
    @Override
    public String toString() {
        return super.toString() +
               ", Medications Count: " + medications.size() +
               ", Prescriptions Count: " + prescriptions.size();
    }
}