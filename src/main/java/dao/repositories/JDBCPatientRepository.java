package dao.repositories;

import dao.repositories.PatientRepository;
import dao.model.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCPatientRepository implements PatientRepository {
    public void delete(int idDelete) {

    }

    public List<Patient> getAll(){
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1,"Iván", LocalDate.parse("2005-04-22"),"123-456-789"));
        patients.add(new Patient(2,"María", LocalDate.parse("1990-12-15"),"987-654-321"));
        patients.add(new Patient(3, "Carlos", LocalDate.parse("1985-06-22"), "612-345-678"));
        return patients;
    }

    public int add(Patient patient){
        return 1;
    }

    public void update(Patient patient){
    }



    public boolean login(String patient, String password){
        return patient.equals("root") && password.equals("quevedo2dam");
    }
}
