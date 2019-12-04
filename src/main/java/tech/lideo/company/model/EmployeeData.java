package tech.lideo.company.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeData {
    private UUID id;
    private Long pesel;
    private LocalDate date;
    private BigDecimal salary;

    public EmployeeData(Long pesel, LocalDate date, BigDecimal salary) {
        this.id = UUID.randomUUID();
        this.pesel = pesel;
        this.date = date;
        this.salary = salary;
    }

    public EmployeeData() {
    }

    public EmployeeData(UUID id, Long pesel, LocalDate date, BigDecimal salary) {
        this.id = id;
        this.pesel = pesel;
        this.date = date;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
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
