package com.eleventh.employees.service;

import com.eleventh.employees.model.Employee;
import com.eleventh.employees.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public int getSalarySum() {
        return employees.entrySet().stream()
                .mapToInt(e -> e.getValue().getSalary())
                .sum();
    }

    public List<Employee> getEmployeesWithHighSalary() {
        int averageSalary = getSalaryAverage();
        return employees.values().stream()
                .filter(e -> e.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }

    public int getSalaryAverage(){
        int averageSalary = 0;
        if (employees.values().size() > 0) {
            averageSalary = employees.values().stream()
                    .mapToInt(Employee::getSalary)
                    .sum() / employees.values().size();
        }
        return averageSalary;
    }

    public Employee getEmployeeWithMaxSalary() {
        return employees.entrySet().stream()
                .map(e -> e.getValue())
                .max(Comparator.comparing(e -> e.getSalary()))
                .get();
    }

    public Employee getEmployeeWithMinSalary() {
        return employees.entrySet().stream()
                .map(e -> e.getValue())
                .min(Comparator.comparing(e -> e.getSalary()))
                .get();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should not be empty");
        }
        Employee employee = new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        employees.put(employee.getId(), employee);
        return employee;
    }
}
