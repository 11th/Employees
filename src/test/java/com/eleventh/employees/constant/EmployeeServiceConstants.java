package com.eleventh.employees.constant;

import com.eleventh.employees.model.Employee;
import com.eleventh.employees.record.EmployeeRequest;

import java.util.List;
import java.util.Map;

public class EmployeeServiceConstants {
    public static final String EMPLOYEE_FIRSTNAME = "First";
    public static final String EMPLOYEE_LASTNAME = "Last";
    public static final String FIRST_EMPLOYEE_FIRSTNAME = "First1";
    public static final String FIRST_EMPLOYEE_LASTNAME = "Last1";
    public static final String SECOND_EMPLOYEE_FIRSTNAME = "First2";
    public static final String SECOND_EMPLOYEE_LASTNAME = "Last2";
    public static final String THIRD_EMPLOYEE_FIRSTNAME = "First3";
    public static final String THIRD_EMPLOYEE_LASTNAME = "Last3";
    public static final String FOURTH_EMPLOYEE_FIRSTNAME = "First4";
    public static final String FOURTH_EMPLOYEE_LASTNAME = "Last4";

    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_2 = 2;
    public static final int DEPARTMENT_N = 3;

    public static final int SALARY1 = 1000;
    public static final int SALARY2 = 2000;
    public static final int SALARY3 = 3000;
    public static final int SALARY4 = 4000;

    public static final int SALARY_SUM_DEP1 = SALARY1 + SALARY2;
    public static final int SALARY_SUM_DEP2 = SALARY3 + SALARY4;
    public static final int SALARY_SUM = SALARY_SUM_DEP1 + SALARY_SUM_DEP2;
    public static final int SALARY_AVERAGE = SALARY_SUM / 4;

    public static final int KEY_1 = 1;
    public static final int KEY_2 = 2;
    public static final int KEY_3 = 3;
    public static final int KEY_4 = 4;

    public static final Employee EMPLOYEE_1 = new Employee(FIRST_EMPLOYEE_FIRSTNAME, FIRST_EMPLOYEE_LASTNAME, DEPARTMENT_1, SALARY1);
    public static final Employee EMPLOYEE_2 = new Employee(SECOND_EMPLOYEE_FIRSTNAME, SECOND_EMPLOYEE_LASTNAME, DEPARTMENT_1,SALARY2);
    public static final Employee EMPLOYEE_3 = new Employee(THIRD_EMPLOYEE_FIRSTNAME, THIRD_EMPLOYEE_LASTNAME, DEPARTMENT_2, SALARY3);
    public static final Employee EMPLOYEE_4 = new Employee(FOURTH_EMPLOYEE_FIRSTNAME, FOURTH_EMPLOYEE_LASTNAME, DEPARTMENT_2, SALARY4);

    public static final Map<Integer, Employee> EMPLOYEE_MAP = Map.of(
            KEY_1, EMPLOYEE_1,
            KEY_2, EMPLOYEE_2,
            KEY_3, EMPLOYEE_3,
            KEY_4, EMPLOYEE_4
    );

    public static final List<Employee> EMPLOYEE_HIGH_SALARY_LIST = List.of(EMPLOYEE_3, EMPLOYEE_4);

    public static final EmployeeRequest EMPLOYEE_REQUEST_1 = new EmployeeRequest();
    public static final EmployeeRequest EMPLOYEE_REQUEST_2 = new EmployeeRequest();
    public static final EmployeeRequest EMPLOYEE_REQUEST_3 = new EmployeeRequest();
    public static final EmployeeRequest EMPLOYEE_REQUEST_4 = new EmployeeRequest();

    static {
        EMPLOYEE_REQUEST_1.setFirstName(FIRST_EMPLOYEE_FIRSTNAME);
        EMPLOYEE_REQUEST_1.setLastName(FIRST_EMPLOYEE_LASTNAME);
        EMPLOYEE_REQUEST_1.setDepartment(DEPARTMENT_1);
        EMPLOYEE_REQUEST_1.setSalary(SALARY1);

        EMPLOYEE_REQUEST_2.setFirstName(SECOND_EMPLOYEE_FIRSTNAME);
        EMPLOYEE_REQUEST_2.setLastName(SECOND_EMPLOYEE_LASTNAME);
        EMPLOYEE_REQUEST_2.setDepartment(DEPARTMENT_1);
        EMPLOYEE_REQUEST_2.setSalary(SALARY2);

        EMPLOYEE_REQUEST_3.setFirstName(THIRD_EMPLOYEE_FIRSTNAME);
        EMPLOYEE_REQUEST_3.setLastName(THIRD_EMPLOYEE_LASTNAME);
        EMPLOYEE_REQUEST_3.setDepartment(DEPARTMENT_2);
        EMPLOYEE_REQUEST_3.setSalary(SALARY3);

        EMPLOYEE_REQUEST_4.setFirstName(FOURTH_EMPLOYEE_FIRSTNAME);
        EMPLOYEE_REQUEST_4.setLastName(FOURTH_EMPLOYEE_LASTNAME);
        EMPLOYEE_REQUEST_4.setDepartment(DEPARTMENT_2);
        EMPLOYEE_REQUEST_4.setSalary(SALARY4);
    }
}
