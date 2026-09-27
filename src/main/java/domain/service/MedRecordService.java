package domain.service;

import dao.model.MedRecord;
import dao.model.Patient;
import dao.repositories.JDBCMedRecordRepository;
import domain.mappers.MedRecordDTOMapper;
import domain.model.MedRecordDTO;

public class MedRecordService {
    private final JDBCMedRecordRepository JDBCMedRecordRepository;
    private final MedRecordDTOMapper medRecordDTOMapper;

    public MedRecordService(JDBCMedRecordRepository jdbcMedRecordRepository, MedRecordDTOMapper medRecordDTOMapper) {
        JDBCMedRecordRepository = jdbcMedRecordRepository;
        this.medRecordDTOMapper = medRecordDTOMapper;
    }

    public MedRecord getMedRecordByPatient(Patient patient) {
        return medRecordDTOMapper.getAllMedRecordsByPatient(patient);
    }

//    public void addMedRecord(Patient patient) {
//        return MedRecordDTOMapper.addMedRecord(patient);
//    }

    public MedRecord updateMedRecord(MedRecord medRecord) {
        return medRecordDTOMapper.updateMedRecord(medRecord);
    }
}
