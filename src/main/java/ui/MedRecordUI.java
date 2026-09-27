package ui;

import dao.model.MedRecord;
import dao.model.Patient;
import domain.model.MedRecordDTO;
import domain.service.MedRecordService;

public class MedRecordUI {
    private final MedRecordService medRecordService;

    public MedRecordUI(MedRecordService medRecordService) {
        this.medRecordService = medRecordService;
    }


    public MedRecord getMedRecordByPatient(Patient patient) {
        return medRecordService.getMedRecordByPatient(patient);
    }

    public MedRecordDTO addMedRecord(Patient patient) {
        medRecordService.addMedRecord(patient);
    }

    public MedRecord updateMedRecord(MedRecord medRecord) {
        medRecordService.updateMedRecord(medRecord);
    }
}
