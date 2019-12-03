package tech.lideo.company.service;

import tech.lideo.company.model.EmployeeDTO;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeDataNotFoundException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;

public interface IEmployeeService {
    /**
     *
     */
//    List<EmployeeDTO> findAll();

    EmployeeDTO create(EmployeeDTO dto) throws EmployeeDataNotFoundException, EmployeePeselException, EmployeeNotFoundException, EmployeeAlreadyExistsException;


//    boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;
//
//    Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException;
//
//    Employee update(String actualFirstName, String actualLastName, String actualPesel,
//                    String newFirstName, String newLastName, String newPesel)
//            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException;
}
