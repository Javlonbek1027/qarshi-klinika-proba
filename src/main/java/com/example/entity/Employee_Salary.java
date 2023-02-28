package com.example.entity;

import com.example.enums.SalaryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class Employee_Salary {
    public Employee_Salary(Employee employee, Double salary, SalaryStatus salaryStatus, LocalDateTime operationTime, String definition) {
        this.employee = employee;
        this.salary = salary;
        this.salaryStatus = salaryStatus;
        this.operationTime = operationTime;
        this.definition = definition;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    @Min(1000000)
    @Max(50000000)
    private Double salary;

    @Column
    private SalaryStatus salaryStatus = SalaryStatus.NAQT;

    @Column(nullable = false)
    private LocalDateTime operationTime = LocalDateTime.now();

    @Column
    @Length(max = 500)
    private String definition;
}
