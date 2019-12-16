package tech.lideo.company.model;

import java.time.LocalDate;

public class Employee implements Identifiable, Identifiable2 {
    private Long id;
    private String firstName;
    private String lastName;
    private Long pesel;
    private LocalDate created;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, Long pesel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.created = LocalDate.now();
    }

    public Employee(Long id, String firstName, String lastName, Long pesel, LocalDate created) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.created = created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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
