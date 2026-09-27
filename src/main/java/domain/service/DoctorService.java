package domain.service;

import dao.model.Doctor;
import dao.repositories.JDBCDoctorRepository;
import domain.mappers.DoctorDTOMapper;
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

    public List<Doctor> getAllDoctors() {
        return JDBCDoctorRepository.getAllDoctors();
    }
}
