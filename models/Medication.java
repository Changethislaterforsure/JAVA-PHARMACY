package models;

import java.time.LocalDate;
import java.util.Random;

/**
 * Represents a medication in the pharmacy system.
 * Stores details such as name, dose, quantity in stock, and expiry date.
 */
public class Medication {

    private String id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    /**
     * Constructs a new Medication object with a randomly assigned expiry date.
     *
     * @param id              the unique medication ID
     * @param name            the name of the medication
     * @param dose            the dosage (e.g., "500mg")
     * @param quantityInStock the quantity currently in stock
     */
    public Medication(String id, String name, String dose, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    /**
     * Generates a random expiry date either in the past or future.
     * @return a random LocalDate
     */
    private LocalDate generateRandomExpiryDate() {
        Random rand = new Random();
        int daysOffset = rand.nextInt(365 * 2); // up to 2 years
        boolean isExpired = rand.nextBoolean();

        return isExpired
                ? LocalDate.now().minusDays(daysOffset)
                : LocalDate.now().plusDays(daysOffset);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Checks whether the medication is currently expired.
     *
     * @return true if the medication is past its expiry date
     */
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    /**
     * Returns a string representation of the medication.
     *
     * @return formatted string with medication details
     */
    @Override
    public String toString() {
        return "Medication [ID: " + id + ", Name: " + name +
               ", Dose: " + dose + ", Stock: " + quantityInStock +
               ", Expiry: " + expiryDate + "]";
    }
}