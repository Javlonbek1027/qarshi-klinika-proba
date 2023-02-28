package com.example.repository;

import com.example.entity.Complaints;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintsRepository extends CrudRepository<Complaints,Integer> {

}
