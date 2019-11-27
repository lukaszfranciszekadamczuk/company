package tech.lideo.company.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class EmployeeData {

    private UUID salaryId;
    private String employeeId;
    private List<Salary> salary;

    public EmployeeData(String employeeId, List<Salary> salary) {
        this.salaryId = UUID.randomUUID();
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public EmployeeData() {
    }

    public UUID getSalaryId() {
        return salaryId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public List<Salary> getSalary() {
        return salary;
    }
}
