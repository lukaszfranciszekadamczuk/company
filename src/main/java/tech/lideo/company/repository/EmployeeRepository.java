package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import java.io.IOException;
import java.util.List;

public interface EmployeeRepository {

    /**
     *
     */

    List<Employee> findAll();

    List<Employee> find(String firstName, String lastName) throws EmployeeNotFoundException;

    String create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IOException;

    String delete(String firstName, String lastName) throws EmployeeNotFoundException;

    String update(String firstName, String lastName, String newFirstName, String newLastName) throws EmployeeNotFoundException;
}