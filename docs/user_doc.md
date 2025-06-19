# 🧪 Pharmacy Management System - User Documentation

The Pharmacy Management System is a Java-based application designed to manage doctors, patients, medications, and prescriptions using object-oriented programming principles.

This version is built for individual testing without a scanner-based menu.

---

## 🔧 How to use the program
Open the project folder and ensure your current directory is 'JAVA-PHARMACY'. To run the program, open the applicable terminal (bash for me) and enter: java app.PharmacyApp. The terminal should now display a number of results as it runs through all the tests contained in PharmacyApp.java, which stands in for user input since there is no menu. 

Specifically you should be seeing a before and after of doctor, patient and medication info showing that it has been edited then a confirmation that it has been deleted. After that a report of expired prescriptions, a list of prescriptions issued by Dr.Jones, a prescription summary for Sarah Lee and then confirmation that medications are being restocked to a stock of 100. 

## 📊 How does it really work?
Now, since there is no user input this program could just be full of print statements and a user may not ever know the difference unless they took a peek under the hood. However this is not the case, this program makes use of 5 core classes that make use of unique logic, a system class that simulates a backend of the system and an app class which serves as the sort of front door, containing all the things a user would actually see. Let's break it down a little further below;

### Person
The person class is the foundation of the program, being a super class that acts as a base for both Patient and Doctor classes since it holds all the logic for common personal information as well as their shared getters and setters. 

### Doctor
The doctor class concerns itself with doctors issuing prescriptions. It ties a specialization and list of patients to a doctor and allows for these things to be edited. A patient is tied to their doctor when that doctor issues them a prescription.

### Patient
The other extension of the Person class, the patient class ties medications and prescriptions to a patient. Just like the doctor class a patient can be edited or removed here.

### Medication
This class represents medications available in the pharmacy system, holding its unique ID, name, doseage, number in stock and expiry date. This class contains unique logic that randomly generates a expiry date (to avoid me having to make them up myself) and a special method called `isExpired()` that checks to see if the medication has passed its expiry date. 

### Prescription
Tis class represents a record that links together doctors, patients and medication. It will include a unique ID, the doctor, the patient, the medication, an issue date and expiry date. When this specific class is called in your output it's logic is designed to set the expiry date 1 year after the issue date.

### MedicationTrackingSystem
This is the controller class, it manages all of the operations and data which is why its quite big compared to our other classes. It grabs the list of doctors and patients, deletes information, edits information and collects it for query. It encapsulates all of the backend system logic.

### PharmacyApp
This is the main class currently used to test the features of the program. It includes hardcoded data like the names of doctors as well as method calls to show off the functionality of the program. The use of a menu could change how this class is set up, being able to accept user input to determine a doctors name but for now I have just made them up myself.





## 📘 Class Diagram with Associations

```plaintext
                  +------------------+
                  |     Person       |  (Superclass)
                  +------------------+
                  | - id             |
                  | - name           |
                  | - age            |
                  | - phoneNumber    |
                  +------------------+
                          ▲
                          |
          +---------------+----------------+
          |                                |
  +---------------+              +----------------+
  |    Doctor     |              |    Patient     |
  +---------------+              +----------------+
  | - specialization            | - medications   |
  | - patients (List<Patient>)  | - prescriptions |
  +---------------+              +----------------+
          ▲                                ▲
          |                                |
          |                                |
          |               +----------------+------------------+
          |               |                                   |
          |       +-------------------+                +--------------------+
          |       |   Prescription    |<-------------->|    Medication      |
          |       +-------------------+                +--------------------+
          |       | - id              |                | - id               |
          |       | - doctor          |                | - name             |
          |       | - patient         |                | - dose             |
          |       | - medication      |                | - quantityInStock  |
          |       | - issueDate       |                | - expiryDate       |
          |       | - expiryDate      |                +--------------------+
          |       +-------------------+
          |
  +-----------------------------+
  | MedicationTrackingSystem    |
  +-----------------------------+
  | - doctors (List<Doctor>)    |
  | - patients (List<Patient>)  |
  | - medications (List<Medication>) |
  | - prescriptions (List<Prescription>) |
  +-----------------------------+
  | +addDoctor(...)             |
  | +acceptPrescription(...)    |
  | +edit/delete/...            |
  +-----------------------------+