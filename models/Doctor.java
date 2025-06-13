package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a doctor in the pharmacy system.
 * Inherits common person attributes from the Person class.
 */
public class Doctor extends Person {

    /**
     * The medical specialization of the doctor.
     */
    private String specialization;

    /**
     * List of patients assigned to this doctor.
     */
    private List<Patient> patients;

    /**
     * Constructs a new Doctor with the given details.
     *
     * @param id            the doctor's unique ID
     * @param name          the doctor's name
     * @param age           the doctor's age
     * @param phoneNumber   the doctor's phone number
     * @param specialization the doctor's medical specialization
     */
    public Doctor(String id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    /**
     * Gets the doctor's specialization.
     *
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets the doctor's specialization.
     *
     * @param specialization the new specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets the list of patients assigned to the doctor.
     *
     * @return list of patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Adds a patient to the doctor's list.
     *
     * @param patient the patient to add
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Removes a patient from the doctor's list.
     *
     * @param patient the patient to remove
     */
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    /**
     * Returns a string representation of the doctor.
     *
     * @return formatted string with doctor details
     */
    @Override
    public String toString() {
        return super.toString() +
               ", Specialization: " + specialization +
               ", Patient Count: " + patients.size();
    }
}