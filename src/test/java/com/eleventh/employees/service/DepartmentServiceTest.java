package com.eleventh.employees.service;

import com.eleventh.employees.constant.EmployeeServiceConstants;
import com.eleventh.employees.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService out;
    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        out = new DepartmentService(employeeService);
    }

    @Test
    void getEmployeesByDepartment() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EmployeeServiceConstants.EMPLOYEE_MAP.values());
        Assertions.assertThat(out.getEmployeesByDepartment(EmployeeServiceConstants.DEPARTMENT_1))
                .contains(EmployeeServiceConstants.EMPLOYEE_1);
        Assertions.assertThat(out.getEmployeesByDepartment(EmployeeServiceConstants.DEPARTMENT_1))
                .contains(EmployeeServiceConstants.EMPLOYEE_2);
        Mockito.verify(employeeService, Mockito.times(2)).getAllEmployees();
    }

    @Test
    void getEmployeesByDepartmentNotExists() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EmployeeServiceConstants.EMPLOYEE_MAP.values());
        Assertions.assertThat(out.getEmployeesByDepartment(EmployeeServiceConstants.DEPARTMENT_N)).hasSize(0);
        Mockito.verify(employeeService, Mockito.only()).getAllEmployees();
    }

    @Test
    void getSalarySumByDepartment() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EmployeeServiceConstants.EMPLOYEE_MAP.values());
        Assertions.assertThat(out.getSalarySumByDepartment(EmployeeServiceConstants.DEPARTMENT_1))
                .isEqualTo(EmployeeServiceConstants.SALARY_SUM_DEP1);
        Mockito.verify(employeeService, Mockito.only()).getAllEmployees();
    }

    @Test
    void getSalarySumByDepartmentNotExists() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EmployeeServiceConstants.EMPLOYEE_MAP.values());
        Assertions.assertThat(out.getSalarySumByDepartment(EmployeeServiceConstants.DEPARTMENT_N)).isEqualTo(0);
        Mockito.verify(employeeService, Mockito.only()).getAllEmployees();
    }

    @Test
    void getMaxSalaryByDepartment() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EmployeeServiceConstants.EMPLOYEE_MAP.values());
        Assertions.assertThat(out.getMaxSalaryByDepartment(EmployeeServiceConstants.DEPARTMENT_1))
                .isEqualTo(EmployeeServiceConstants.SALARY2);
        Mockito.verify(employeeService, Mockito.only()).getAllEmployees();
    }

    @Test
    void getMaxSalaryByDepartmentFromEmptyMap() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(new HashMap<Integer, Employee>().values());
        Assertions.assertThat(out.getMaxSalaryByDepartment(EmployeeServiceConstants.DEPARTMENT_1)).isEqualTo(0);
        Mockito.verify(employeeService, Mockito.only()).getAllEmployees();
    }

    @Test
    void getMinSalaryByDepartment() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EmployeeServiceConstants.EMPLOYEE_MAP.values());
        Assertions.assertThat(out.getMinSalaryByDepartment(EmployeeServiceConstants.DEPARTMENT_1))
                .isEqualTo(EmployeeServiceConstants.SALARY1);
        Mockito.verify(employeeService, Mockito.only()).getAllEmployees();
    }

    @Test
    void getMinSalaryByDepartmentFromEmptyMap() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(new HashMap<Integer, Employee>().values());
        Assertions.assertThat(out.getMinSalaryByDepartment(EmployeeServiceConstants.DEPARTMENT_1)).isEqualTo(0);
        Mockito.verify(employeeService, Mockito.only()).getAllEmployees();
    }

    @Test
    void getEmployeesGroupedByDepartment() {
        Assertions.assertThat(employeeService).isNotNull();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EmployeeServiceConstants.EMPLOYEE_MAP.values());
        Assertions.assertThat(out.getEmployeesGroupedByDepartment())
                .hasSize(2);
        Assertions.assertThat(out.getEmployeesGroupedByDepartment().values())
                .first()
                .extracting(List::size).isEqualTo(2);
        Assertions.assertThat(out.getEmployeesGroupedByDepartment().values())
                .last()
                .extracting(List::size).isEqualTo(2);
        Mockito.verify(employeeService, Mockito.times(3)).getAllEmployees();
    }
}