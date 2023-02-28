package com.example.repository;

import com.example.entity.Complaints;
import com.example.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Integer> {

}
