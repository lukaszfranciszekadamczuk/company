package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException;

    Employee create(Employee model) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException;

    String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException;

    Employee update(Long pesel, Employee model) throws EmployeeNotFoundException, IllegalArgumentException;

    void clear();

    int size();

    void validate(Employee model);

    void validate(Long pesel);
}