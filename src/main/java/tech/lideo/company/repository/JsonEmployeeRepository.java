package tech.lideo.company.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.util.Collections.emptyMap;
import static java.util.Objects.isNull;

@Repository
public class JsonEmployeeRepository implements EmployeeRepository {

    private ObjectMapper mapper = new ObjectMapper();
    private JsonArray array = Json.createArrayBuilder().build();
    private String path = "persistence/employee-repository.json";

    @Override
    public Employee create(Employee employee) throws IOException, EmployeeNotFoundException {

        if (isNull(employee.getId()) || isNull(employee.getFirstName()) || isNull(employee.getLastName())) {
            throw new IllegalArgumentException();
        }

        JsonBuilderFactory factory = Json.createBuilderFactory(emptyMap());

        JsonArray value = factory.createArrayBuilder()
                .add(factory.createObjectBuilder()
                        .add("id", employee.getId())
                        .add("firstName", employee.getFirstName())
                        .add("lastName", employee.getLastName())
                        .add("created", employee.getCreated().toString()))
                .build();

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), value);
        List<Employee> employeeList = (List<Employee>) mapper.readValue(path, Employee.class);

        return employeeList.stream()
                .findFirst()
                .filter(e -> e.getId().equals(employee.getId()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Employee find(Long id) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }
}
