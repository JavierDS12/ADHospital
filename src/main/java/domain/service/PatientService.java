package domain.service;

import dao.model.Patient;
import dao.repositories.JDBCPatientRepository;
import domain.mappers.PatientDTOMapper;
import domain.model.CredentialDTO;
import domain.model.PatientDTO;
import jakarta.inject.Inject;

import java.util.List;

public class PatientService {
    private final JDBCPatientRepository JDBCpatientRepository;
    private final PatientDTOMapper patientDTOMapper;

    @Inject
    public PatientService(JDBCPatientRepository JDBCpatientRepository, PatientDTOMapper patientDTOMapper) {
        this.JDBCpatientRepository = JDBCpatientRepository;
        this.patientDTOMapper = patientDTOMapper;
    }
    public List<PatientDTO> getPatients(){
        List<Patient> patients = JDBCpatientRepository.getAll();
        List<PatientDTO> patientDTOs = List.of();
        for (int i = 0; i < patients.size(); i++) {
            patientDTOs.add(patientDTOMapper.entityToDto(patients.get(i)));
        }
        return patientDTOs;
    }

    public int addPatient(Patient patient){

        JDBCpatientRepository.add(patient);
        return 0;
    }

    public void updatePatient(Patient patient){
        JDBCpatientRepository.update(patient);
    }

    public void deletePatient(int id ){
        JDBCpatientRepository.delete(id);
    }

//    public boolean login(CredentialDTO credential) {
//        return JDBCpatientRepository.login(patient, password);
//    }
}
