package tech.lideo.company.service;

import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exception.*;
import tech.lideo.company.service.exception.EmployeeIncompatibleWithEmployeeData;

import java.util.List;

public interface IEmployeeService {
    /**
     *
     */
    List<EmployeeDTO> findAll();

    EmployeeDTO create(EmployeeDTO dto) throws EmployeePeselException, EmployeeNotFoundException,
            EmployeeAlreadyExistsException, EmployeeDataNotFoundException,
            EmployeeIncompatibleWithEmployeeData, EmployeAlreadyHaveSalaryForThisDayException;

    boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;

    Employee update(String actualFirstName, String actualLastName, String actualPesel,
                    String newFirstName, String newLastName, String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException;

    void clear();

    int size();

    void validate(EmployeeDTO dto) throws EmployeeIncompatibleWithEmployeeData;

}
