JAVA-PHARMACY/
├── app/
│   └── PharmacyApp.java             # Entry point with main() method
│
├── docs/
│   ├── dev_doc.md                   # Development documentation
│   ├── placeholder.md              # Placeholder file (safe to remove later)
│   └── user_doc.md                  # User instructions
│
├── models/                          # Core entity models
│   ├── Doctor.java
│   ├── Medication.java
│   ├── Patient.java
│   ├── Person.java
│   └── Prescription.java
│
├── system/
│   └── MedicationTrackingSystem.java  # Manages system-wide logic and data
│
├── .gitignore
└── README.md                         # Project overview for GitHub

--------------------------------------------------------------------------------------


## Theoretical Database Design (Entity Relationships)

### Entities & Attributes

#### 1. **Person** (abstract base, not a table — use inheritance)
Used to derive Doctor and Patient.

---

#### 2. **Doctor**
| Field         | Type        | Description                       |
|---------------|-------------|-----------------------------------|
| doctor_id     | VARCHAR(10) | Primary Key                       |
| name          | VARCHAR(50) | Full name of the doctor           |
| age           | INT         | Age of the doctor                 |
| phone_number  | VARCHAR(20) | Contact phone number              |
| specialization| VARCHAR(50) | Medical field specialization      |

---

#### 3. **Patient**
| Field         | Type        | Description                       |
|---------------|-------------|-----------------------------------|
| patient_id    | VARCHAR(10) | Primary Key                       |
| name          | VARCHAR(50) | Full name of the patient          |
| age           | INT         | Age of the patient                |
| phone_number  | VARCHAR(20) | Contact phone number              |

---

#### 4. **Medication**
| Field          | Type        | Description                            |
|----------------|-------------|----------------------------------------|
| medication_id  | VARCHAR(10) | Primary Key                            |
| name           | VARCHAR(50) | Name of the medication                 |
| dose           | VARCHAR(30) | Dosage (e.g., "500mg")                 |
| quantity_stock | INT         | Current quantity in stock              |
| expiry_date    | DATE        | Expiration date of the medication      |

---

#### 5. **Prescription**
| Field           | Type        | Description                                  |
|-----------------|-------------|----------------------------------------------|
| prescription_id | VARCHAR(10) | Primary Key                                  |
| doctor_id       | VARCHAR(10) | Foreign Key → Doctor(doctor_id)             |
| patient_id      | VARCHAR(10) | Foreign Key → Patient(patient_id)           |
| medication_id   | VARCHAR(10) | Foreign Key → Medication(medication_id)     |
| issue_date      | DATE        | Date prescription was issued                 |
| expiry_date     | DATE        | Defaults to 1 year after `issue_date`        |

---

### Relationships

- A **Doctor** can be associated with multiple **Patients**
- A **Patient** can have multiple **Prescriptions**
- A **Prescription** is linked to one **Doctor**, one **Patient**, and one **Medication**


------------------------------------------------------------------------------------------


## Development standards
This project follows a number of developmental standard practices.

### Structure
My project is divided into logical packages with a 'models' folder containing my main data classes while a 'system' folder containing my main system logic. All of this documentation is also kept seperate in it's own 'docs' folder so that it can be easily located. 

### Naming Convention
Fairly consistant naming convention's can be found throught the project. Class names such as Medication and MedicationTrackingSystem use PascalCase. Variables and methods like addPatient use camelCase (my personal favorite). Package names like 'models' and 'app' will always use lowercase.

### Documentation
On top of this doc all classes include javadoc comments with one at the top explaining the classes purpose. Parameters, return values, and behaviors are clearly described using `@param` and `@return` tags.

### Git
This project uses Git, making use of commits and commit messages to keep an online repository so that even if my computer explodes, is stolen or eaten by a werewolf the work completed is not lost. 

