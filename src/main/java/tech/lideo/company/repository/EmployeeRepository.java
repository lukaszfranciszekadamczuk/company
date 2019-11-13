package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;
import tech.lideo.company.repository.exceptions.NoEmployeesException;

import java.io.IOException;
import java.util.List;

public interface EmployeeRepository {

    /**
     *
     */

    List<Employee> findAll() throws NoEmployeesException;

    List<Employee> find(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IOException;

    String delete(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee update(String firstName, String lastName, String newFirstName, String newLastName) throws EmployeeNotFoundException;
}