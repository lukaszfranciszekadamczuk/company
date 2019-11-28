package tech.lideo.company.service;

import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeDTO;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.exception.*;

import java.util.List;

public interface IEmployeeService {
    /**
     *
     */
    List<EmployeeDTO> findAll();

    EmployeeDTO create(Employee employee, EmployeeData employeeData)
            throws EmployeeAlreadyExistsException, EmployeeNotFoundException,
            EmployeePeselException, EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException;

    boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee update(String actualFirstName, String actualLastName, String actualPesel,
                    String newFirstName, String newLastName, String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException;
}
