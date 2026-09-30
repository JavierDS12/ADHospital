package ui;

import dao.model.Patient;
import domain.model.CredentialDTO;
import domain.model.PatientDTO;
import domain.service.PatientService;
import jakarta.inject.Inject;

import java.util.List;

public class PatientUI {
    private final PatientService patientService;

    @Inject
    public PatientUI(PatientService patientService){
        this.patientService = patientService;
    }
    public List<PatientDTO> getPatients(){
        return patientService.getPatients();
    }

    public int addPatient(PatientDTO patientDTO){
        return patientService.addPatient(patientDTO);
    }

    public void updatePatient(PatientDTO patientDTO){
        patientService.updatePatient(patientDTO);
    }

    public void deletePatient(int id){
        patientService.deletePatient(id);
    }

//    public boolean login(CredentialDTO credential){
//        return patientService.login(patient,password);
//    }

    public boolean login(String username, String password) {
        return true;
    }
}
