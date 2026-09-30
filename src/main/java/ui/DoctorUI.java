package ui;

import dao.model.Doctor;
import domain.model.DoctorDTO;
import domain.model.PatientDTO;
import domain.service.DoctorService;
import domain.service.PatientService;
import jakarta.inject.Inject;

import java.util.List;

public class DoctorUI {
    private final DoctorService doctorService;

    @Inject
    public DoctorUI(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    public List<DoctorDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
}
