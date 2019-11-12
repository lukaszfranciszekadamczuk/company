package tech.lideo.company;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.JsonEmployeeRepository;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import java.io.IOException;

public class MyRunner {
    private static JsonEmployeeRepository repository = new JsonEmployeeRepository();

    public static void main(String[] args) throws IOException, EmployeeNotFoundException, EmployeeAlreadyExistsException {
        repository.create(new Employee(666L, "name666", "name666"));
    }
}
