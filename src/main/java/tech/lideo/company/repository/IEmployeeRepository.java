package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;
import tech.lideo.company.repository.exception.MissingReqiredUpdateArgumentsException;

import java.util.List;

public interface IEmployeeRepository {

    /**
     *
     *
     */
    List<Employee> findAll();

    int employeeListSize();

    Employee create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, EmployeePeselException;

    boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee update(String actualFirstName, String actualLastName, String actualPesel, String newFirstName, String newLastName, String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException;
}
