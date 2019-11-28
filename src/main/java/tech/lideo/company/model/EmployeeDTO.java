package tech.lideo.company.model;

import java.util.List;
import java.util.Objects;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private Long pesel;
    private List<EmployeeDataDTO> salary;

    public EmployeeDTO(String firstName, String lastName, Long pesel, List<EmployeeDataDTO> salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.salary = salary;
    }

    public EmployeeDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(pesel, that.pesel) &&
                Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, pesel, salary);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", salary=" + salary +
                '}';
    }
}
