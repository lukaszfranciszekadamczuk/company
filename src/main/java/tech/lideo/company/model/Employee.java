package tech.lideo.company.model;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate created;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getCreated() {
        return created;
    }
}
