package domain.service;

import dao.model.Patient;
import dao.repositories.JDBCPatientRepository;
import domain.mappers.PatientDTOMapper;
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
        List<PatientDTO> listPatientDTOs = List.of();
        for (int i = 0; i < patients.size(); i++) {
            listPatientDTOs.add(patientDTOMapper.entityToDto(patients.get(i)));
        }
        return listPatientDTOs;
    }

    public int addPatient(PatientDTO patientDTO){
        JDBCpatientRepository.add(patientDTOMapper.dtoToEntity(patientDTO));
        return 0;
    }

    public void updatePatient(PatientDTO patientDTO){
        JDBCpatientRepository.update(patientDTOMapper.dtoToEntity(patientDTO));
    }

    public void deletePatient(int id ){
        JDBCpatientRepository.delete(id);
    }

//    public boolean login(CredentialDTO credential) {
//        return JDBCpatientRepository.login(patient, password);
//    }
}
