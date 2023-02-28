package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.dto.EmployeeFilterDto;
import com.example.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

        public EmployeeDto toDto(Employee employee){
        return new EmployeeDto(employee.getName(),
                employee.getSurname(),
                employee.getEmail(),
                employee.getNumber(),
                employee.getPassword(),
                employee.getAttachId(),
                employee.getStatus(),employee.getRole(),employee.getSpecialty(),
                employee.getPrtId(),
                employee.getRoomForWork());
    }
}
