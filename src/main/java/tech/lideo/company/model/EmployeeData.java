package tech.lideo.company.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeData {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("employee_id")
    private UUID employee_id;
    @JsonProperty("pesel")
    private Long pesel;
    @JsonProperty("startDate")
    private LocalDate startDate;
    @JsonProperty("endDate")
    private LocalDate endDate;
    @JsonProperty("salary")
    private BigDecimal salary;

    public EmployeeData(UUID id, UUID employee_id, Long pesel, LocalDate startDate, LocalDate endDate, BigDecimal salary) {
        this.id = id;
        this.employee_id = employee_id;
        this.pesel = pesel;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
