package tech.lideo.company.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeData implements Identifiable {
    private Long id;
    private Long pesel;
    private LocalDate date;
    private BigDecimal salary;

    public EmployeeData() {
    }

    public EmployeeData(Long id, Long pesel, LocalDate date, BigDecimal salary) {
        this.id = id;
        this.pesel = pesel;
        this.date = date;
        this.salary = salary;
    }

    public Long getId() {
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
