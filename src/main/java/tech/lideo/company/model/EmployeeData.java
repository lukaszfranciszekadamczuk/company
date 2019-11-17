package tech.lideo.company.model;

import java.math.BigDecimal;
import java.util.UUID;

public class EmployeeData {

    private UUID employeeId;
    private BigDecimal salary;

    public EmployeeData(UUID employeeId, BigDecimal salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public EmployeeData() {
    }
}
