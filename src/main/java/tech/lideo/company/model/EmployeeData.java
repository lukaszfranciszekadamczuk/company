package tech.lideo.company.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeData {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("employeeId")
    private String employeeId;
    @JsonProperty("date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    @JsonProperty("salary")
    private BigDecimal salary;

    public EmployeeData(String employeeId, LocalDate date, BigDecimal salary) {
        this.id = UUID.randomUUID();
        this.employeeId = employeeId;
        this.date = date;
        this.salary = salary;
    }

    public EmployeeData() {
    }

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("employeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("date")
    public LocalDate getDate() {
        return date;
    }

    @JsonProperty("salary")
    public BigDecimal getSalary() {
        return salary;
    }
}
