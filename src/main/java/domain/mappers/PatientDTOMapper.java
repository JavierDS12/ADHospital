package domain.mappers;


import dao.model.Patient;
import domain.model.PatientDTO;

public class PatientDTOMapper {
    public Patient dtoToEntity(PatientDTO patientDTO) {

        return new Patient(patientDTO.getId(),patientDTO.getName(),patientDTO.getBirthDate(),patientDTO.getPhone());

    }

    public PatientDTO entityToDto(Patient patientdto) {
        return new PatientDTO(patientdto.getId(), patientdto.getName(),
                patientdto.getBirthDate(), patientdto.getPhone(),0,null,null);
    }

}