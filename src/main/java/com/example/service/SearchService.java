package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.dto.EmployeeFilterDto;
import com.example.entity.Employee;
import com.example.repository.EmployeeCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class SearchService {
    @Autowired
    private EmployeeCustomRepository employeeCustomRepository;
    @Autowired
    private EmployeeService employeeService;
    public List<EmployeeDto> universalSearch(EmployeeFilterDto employeeFilterDto, int page, int size){
        List<Employee> employees = employeeCustomRepository.filter(employeeFilterDto, page, size);
        List<EmployeeDto> employeeFilterDtos = new LinkedList<>();
        for (Employee entity : employees) {
            employeeFilterDtos.add(employeeService.toDto(entity));
        }
        return employeeFilterDtos;
    }
}
