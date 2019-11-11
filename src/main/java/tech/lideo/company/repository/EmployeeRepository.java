package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import java.io.IOException;

public interface EmployeeRepository {

    /**
     *
     */

    Employee create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IOException;

    boolean delete(Long id) throws EmployeeNotFoundException;

    Employee find(Long id) throws EmployeeNotFoundException;

    Employee update(Employee employee) throws EmployeeNotFoundException;
}
