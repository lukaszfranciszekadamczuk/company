package tech.lideo.company.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDataDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    @JsonProperty("salary")
    private BigDecimal salaryValue;

    public EmployeeDataDTO(LocalDate startDate, LocalDate endDate, BigDecimal salaryValue) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.salaryValue = salaryValue;
    }

    public EmployeeDataDTO() {
    }
}
