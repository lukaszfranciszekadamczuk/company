package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    /**
     *
     */
    List<Employee> findAll() throws NoEmployeesException;

    Employee create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException;

    boolean delete(String firstName, String lastName) throws EmployeeNotFoundException;

    List<Employee> find(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee update(String firstName, String lastName, String newFirstName, String newLastName) throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException;
}
