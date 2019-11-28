package tech.lideo.company.controller;

import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeDTO;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.exception.*;

import java.util.List;

public interface IEmployeeController {
    /**
     *
     */
    List<EmployeeDTO> findAll();

    EmployeeDTO create(EmployeeDTO dto)
            throws EmployeeAlreadyExistsException, EmployeeNotFoundException,
            EmployeePeselException, EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException;

    boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee update(String actualFirstName, String actualLastName, String actualPesel, String newFirstName, String newLastName, String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException;
}

