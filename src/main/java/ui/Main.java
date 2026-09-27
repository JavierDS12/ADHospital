package ui;

import dao.model.MedRecord;
import dao.model.Patient;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static void main() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        PatientUI patientui = container.select(PatientUI.class).get();
        DoctorUI doctorUI = container.select(DoctorUI.class).get();
        MedRecordUI medRecordUI = container.select(MedRecordUI.class).get();
        CredentialUI credentialUI = container.select(CredentialUI.class).get();
        Random rand = new Random();
        int id = 0;

        System.out.println("""
                            Hospital CRUD application
                            Please login to continue
                            Username: """);
        System.out.println("Password: ");

        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
        if (patientui.login(username, password)) {
            System.out.println("Login successful!");
            int option;

            do {
                System.out.println("""
             
                Hospital CRUD Application
                1. Get all Patients
                2. Add Patient
                3. Update Patient
                4. Delete Patient
                5. Get all Doctors
                6. Get all Medical Records by patient
                7. Add Medical Record
                8. Update Medical Record
                9. Delete Medical Record
                10. Exit
                """);

                System.out.print("Enter your choice: ");
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("List of patients: " + patientui.getPatients());
                        break;

                    case 2:
                        System.out.println("Add Patient");
                        Patient patient= new Patient();
                        patientui.addPatient(patient);
                        break;

                    case 3:
                        System.out.println("Update Patient");
                        Patient patient2= new Patient();
                        patientui.updatePatient(patient2);

                        break;

                    case 4:
                        System.out.println("Delete Patient");

                        Patient patient3= new Patient();
                        id = rand.nextInt();
                        patientui.deletePatient(id);
                        id = 0;
                        break;

                    case 5:
                        System.out.println("Get all Doctors");
                        doctorUI.getAllDoctors();
                        break;

                    case 6:
                        System.out.println("Get all MedRecords by patient");
                        patient = new Patient();
                        medRecordUI.getMedRecordByPatient(patient);
                        break;

                    case 7:
                        System.out.println("Add MedRecord");
                        patient = new Patient();
                        medRecordUI.addMedRecord(patient);
                        break;

                    case 8:
                        System.out.println("Update MedRecord");
                        MedRecord medRecord = new MedRecord();
                        medRecordUI.updateMedRecord(medRecord);
                        break;

                    case 9:
                        System.out.println("Delete MedRecord");
                        break;

                    case 10:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid option!");
                }

            } while (option != 10);

        } else {
            System.out.println("Login failed!");
        }
    }
}

