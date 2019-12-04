package tech.lideo.company.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDataDTO {
    private Long pesel;
    private LocalDate date;
    private BigDecimal salary;

    public EmployeeDataDTO(Long pesel, LocalDate date, BigDecimal salary) {
        this.pesel = pesel;
        this.date = date;
        this.salary = salary;
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