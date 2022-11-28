package com.eleventh.employees.controller;

import com.eleventh.employees.model.Employee;
import com.eleventh.employees.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeesByDepartment(@PathVariable("id") Integer departmentId){
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public Integer getSalarySumByDepartment(@PathVariable("id") Integer departmentId){
        return departmentService.getSalarySumByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public Integer getMaxSalaryByDepartment(@PathVariable("id") Integer departmentId){
        return departmentService.getMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Integer getMinSalaryByDepartment(@PathVariable("id") Integer departmentId){
        return departmentService.getMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment(){
        return departmentService.getEmployeesGroupedByDepartment();
    }
}
