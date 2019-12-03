package tech.lideo.company.model;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String firstName;
    private String lastName;
    private Long pesel;
    private LocalDate created;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Long pesel) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.created = LocalDate.now();
    }

    public Employee(UUID id, String firstName, String lastName, Long pesel, LocalDate created) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.created = created;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Long getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }
}
