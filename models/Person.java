package models;

/**
 * Represents a general person in the pharmacy system.
 * This is a superclass for both Doctor and Patient classes.
 */
public class Person {
    /**
     * Unique identifier for the person.
     */
    protected String id;

    /**
     * Full name of the person.
     */
    protected String name;

    /**
     * Age of the person.
     */
    protected int age;

    /**
     * Contact phone number of the person.
     */
    protected String phoneNumber;

    /**
     * Constructs a new Person with the given details.
     *
     * @param id           the unique ID of the person
     * @param name         the person's name
     * @param age          the person's age
     * @param phoneNumber  the person's phone number
     */
    public Person(String id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the person's ID.
     *
     * @return the ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the person's ID.
     *
     * @param id the new ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the person's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the person's name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the person's age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the person's age.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the person's phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the person's phone number.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a summary string of the person's details
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
               ", Age: " + age + ", Phone: " + phoneNumber;
    }
}