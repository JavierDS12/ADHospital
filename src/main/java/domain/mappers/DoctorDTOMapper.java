package domain.mappers;

import dao.model.Doctor;
import domain.model.DoctorDTO;

public class DoctorDTOMapper {
    public DoctorDTO entityToDTO(Doctor doctor){
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getSpecialization(), doctor.getPhone());
    }
    public Doctor DTOtoEntity(DoctorDTO doctorDTO){
        return new Doctor(doctorDTO.getId(),doctorDTO.getName(), doctorDTO.getSpetialization(), doctorDTO.getPhone());
    }
}
