yes

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



## Compiling
Since I have just compiled part of this project for the first time in order to test it I thought now would be a good time to check off that part of the documentation. To compile this project I ran javac */*.java inside the bash terminal, javac is the java compiler that rounds up the .java code and turns it into .class files that can actually be read. The */*.java part of my command is technically 2 parts, the first * tells my compiler to target all folders in my directory and *.java tells it to scoop all java files inside those folders. Now that .class files exist for my project I go back to my bash terminal and enter java app.PharmacyApp     which runs my app, which as of writing this adds a prescription to the system. 

### Time dependences
This project was made wholly using standard Java SE 8, no external frameworks or libraries are present, so the only requirements to compile are JDK 8 or higher and a command line interface. 


## How to get the source code from github
To get the source code from github open the terminal of the environment you intend to work in and enter 
git clone https://github.com/Changethislaterforsure/JAVA-PHARMACY
recompile as nessecary via instructions above. 

--------

## 📁 Project File Structure (Plain Text)

```plaintext
JAVA-PHARMACY/
├── app/
│   └── PharmacyApp.java               # Entry point with main() method
│
├── docs/
│   ├── dev_doc.md                     # Development documentation
│   ├── user_doc.md                    # User-facing instructions
│ 
│
├── models/
│   ├── Person.java                    # Superclass for Doctor and Patient
│   ├── Doctor.java                    # Includes specialization and patient list
│   ├── Patient.java                   # Includes prescriptions and medications
│   ├── Medication.java                # Drug details and expiry logic
│   └── Prescription.java              # Links doctor, patient, and medication
│
├── system/
│   └── MedicationTrackingSystem.java  # Controls system logic and data
│
├── .gitignore                         # Git exclusion rules
└── README.md                          # GitHub readme