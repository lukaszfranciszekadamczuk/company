package tech.lideo.company.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "pesel",
        "created"
})

public class Employee {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("pesel")
    private String pesel;
    @JsonProperty("created")
    private LocalDate created;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String pesel) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.created = LocalDate.now();
    }

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("pesel")
    public String getPesel() {
        return pesel;
    }

    @JsonProperty("created")
    public LocalDate getCreated() {
        return created;
    }
}
