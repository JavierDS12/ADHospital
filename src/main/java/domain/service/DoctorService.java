package domain.service;

import dao.model.Doctor;
import dao.repositories.JDBCDoctorRepository;
import domain.mappers.DoctorDTOMapper;
import domain.model.DoctorDTO;
import jakarta.inject.Inject;

import java.util.List;

public class DoctorService {
    private final DoctorDTOMapper doctorDTOMapper;
    private JDBCDoctorRepository JDBCDoctorRepository;

    @Inject
    public DoctorService(JDBCDoctorRepository JDBCdoctorRepository, DoctorDTOMapper doctorDTOMapper) {
        this.JDBCDoctorRepository = JDBCdoctorRepository;
        this.doctorDTOMapper = doctorDTOMapper;
    }

    public List<DoctorDTO> getAllDoctors() {
        List<DoctorDTO> doctorDTOList = List.of();
        for (int i = 0; i < getAllDoctors().size(); i++) {
            doctorDTOList.add(doctorDTOMapper.entityToDTO(JDBCDoctorRepository.getAllDoctors().get(i)));
        }
        return doctorDTOList;
    }
}
