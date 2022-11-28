package com.eleventh.employees.service;

import com.eleventh.employees.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Collection<Employee> getEmployeesByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Integer getSalarySumByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Integer getMaxSalaryByDepartment(Integer departmentId) {
        var optEmployee = employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary));
        if (optEmployee.isEmpty()){
            return 0;
        }
        return optEmployee.get().getSalary();
    }

    public Integer getMinSalaryByDepartment(Integer departmentId) {
        var optEmployee = employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary));
        if (optEmployee.isEmpty()){
            return 0;
        }
        return optEmployee.get().getSalary();
    }

    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
