package tech.lideo.company.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeData {
    private UUID id;
    private UUID employee_id;
    private Long pesel;
    private LocalDate date;
    private BigDecimal salary;

    public EmployeeData(UUID id, UUID employee_id, Long pesel, LocalDate date, BigDecimal salary) {
        this.id = id;
        this.employee_id = employee_id;
        this.pesel = pesel;
        this.date = date;
        this.salary = salary;
    }

    public EmployeeData() {
    }

    public UUID getId() {
        return id;
    }

    public UUID getEmployee_id() {
        return employee_id;
    }

    public Long getPesel() {
        return pesel;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
