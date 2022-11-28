package com.eleventh.employees.service;

import com.eleventh.employees.constant.EmployeeServiceConstants;
import com.eleventh.employees.exception.NotFoundException;
import com.eleventh.employees.model.Employee;
import com.eleventh.employees.record.EmployeeRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeServiceTest {
    private EmployeeService out;

    @BeforeEach
    void setUp() {
        out = new EmployeeService();
        out.addEmployee(EmployeeServiceConstants.EMPLOYEE_REQUEST_1);
        out.addEmployee(EmployeeServiceConstants.EMPLOYEE_REQUEST_2);
        out.addEmployee(EmployeeServiceConstants.EMPLOYEE_REQUEST_3);
        out.addEmployee(EmployeeServiceConstants.EMPLOYEE_REQUEST_4);
    }

    @Test
    void getAllEmployees() {
        var expected = EmployeeServiceConstants.EMPLOYEE_MAP.values();
        var actual = out.getAllEmployees();
        Assertions.assertThat(expected.size()).isEqualTo(actual.size());
        Assertions.assertThat(actual)
                .first()
                .extracting(Employee::getFirstName)
                .isEqualTo(EmployeeServiceConstants.EMPLOYEE_1.getFirstName());
        Assertions.assertThat(actual)
                .last()
                .extracting(Employee::getFirstName)
                .isEqualTo(EmployeeServiceConstants.EMPLOYEE_4.getFirstName());
    }

    @Test
    void getSalarySum() {
        var expectedSalarySum = EmployeeServiceConstants.SALARY_SUM;
        var actualSalarySum = out.getSalarySum();
        Assertions.assertThat(expectedSalarySum).isEqualTo(actualSalarySum);
    }

    @Test
    void getEmployeesWithHighSalary() {
        var expectedList = EmployeeServiceConstants.EMPLOYEE_HIGH_SALARY_LIST;
        var actualList = out.getEmployeesWithHighSalary();
        Assertions.assertThat(expectedList.size()).isEqualTo(actualList.size());
        Assertions.assertThat(actualList)
                .first()
                .extracting(Employee::getSalary)
                .isEqualTo(EmployeeServiceConstants.SALARY3);
        Assertions.assertThat(actualList)
                .last()
                .extracting(Employee::getSalary)
                .isEqualTo(EmployeeServiceConstants.SALARY4);
    }

    @Test
    void getSalaryAverage() {
        var expected = EmployeeServiceConstants.SALARY_AVERAGE;
        var actual = out.getSalaryAverage();
        Assertions.assertThat(expected).isEqualTo(actual);
    }

    @Test
    void getEmployeeWithMaxSalary() {
        var expected = EmployeeServiceConstants.EMPLOYEE_4;
        var actual = out.getEmployeeWithMaxSalary();
        Assertions.assertThat(expected.getSalary()).isEqualTo(actual.getSalary());
    }

    @Test
    void getEmployeeWithMaxSalaryFromEmptyMap() {
        out = new EmployeeService();
        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> {
                    out.getEmployeeWithMaxSalary();
                });
    }

    @Test
    void getEmployeeWithMinSalary() {
        var expected = EmployeeServiceConstants.EMPLOYEE_1;
        var actual = out.getEmployeeWithMinSalary();
        Assertions.assertThat(expected.getSalary()).isEqualTo(actual.getSalary());
    }

    @Test
    void getEmployeeWithMinSalaryFromEmptyMap() {
        out = new EmployeeService();
        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> {
                    out.getEmployeeWithMinSalary();
                });
    }

    @Test
    void addEmployee() {
        Employee expected = new Employee(
                EmployeeServiceConstants.EMPLOYEE_FIRSTNAME,
                EmployeeServiceConstants.EMPLOYEE_LASTNAME,
                EmployeeServiceConstants.DEPARTMENT_1,
                EmployeeServiceConstants.SALARY1);
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setFirstName(expected.getFirstName());
        employeeRequest.setLastName(expected.getLastName());
        employeeRequest.setDepartment(expected.getDepartment());
        employeeRequest.setSalary(expected.getSalary());

        Employee actual = out.addEmployee(employeeRequest);

        Assertions.assertThat(expected.getFirstName()).isEqualTo(actual.getFirstName());
        Assertions.assertThat(expected.getLastName()).isEqualTo(actual.getLastName());

        Assertions.assertThat(out.getAllEmployees()).contains(actual);
    }

    @Test
    void addEmployeeWithEmptyName() {
        out = new EmployeeService();
        EmployeeRequest employeeRequest = new EmployeeRequest();

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    out.addEmployee(employeeRequest);
                });
    }
}