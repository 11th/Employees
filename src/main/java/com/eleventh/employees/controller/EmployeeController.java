package com.eleventh.employees.controller;

import com.eleventh.employees.model.Employee;
import com.eleventh.employees.record.EmployeeRequest;
import com.eleventh.employees.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum(){
        return employeeService.getSalarySum();
    }

    @GetMapping("/employees/salary/average")
    public int getSalaryAverage(){
        return employeeService.getSalaryAverage();
    }

    @GetMapping("/employees/high-salary")
    public Collection<Employee> getEmployeesWithHighSalary(){
        return employeeService.getEmployeesWithHighSalary();
    }

    @GetMapping("/employee/salary/max")
    public Employee getEmployeeWithMaxSalary(){
        return employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("/employee/salary/min")
    public Employee getEmployeeWithMinSalary(){
        return employeeService.getEmployeeWithMinSalary();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.addEmployee(employeeRequest);
    }
}
