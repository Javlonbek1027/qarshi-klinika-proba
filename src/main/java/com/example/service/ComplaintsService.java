package com.example.service;

import com.example.dto.ComplaintDto;
import com.example.entity.Complaints;
import com.example.exeptions.ItemNotFoundException;
import com.example.repository.ComplaintsRepository;
import com.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ComplaintsService {

    @Autowired
    private ComplaintsRepository complaintsRepository;
    @Autowired
    private PatientRepository patientRepository;


    public String whriteComplaint(Integer patientId, String complaint) { // shikoyat yozish
        if (patientRepository.findById(patientId).isPresent()) {
            ComplaintDto complaintDto = new ComplaintDto(patientId, complaint);
            complaintsRepository.save(DtoToEntity(complaintDto));
        }else{
            throw new ItemNotFoundException("Bunday bemor topilmadi");
        }
        return " Well Done!!!";
    }

    private ComplaintDto EntityToDto(Complaints complaint) {
        return new ComplaintDto(complaint.getPatientId(), complaint.getComplaint());
    }

    private Complaints DtoToEntity(ComplaintDto complaint) {
        return new Complaints(complaint.getPatientId(), complaint.getComplaint());
    }
}

