package com.example.repository;

import com.example.entity.EmailEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<EmailEntity,Integer> {
}
