package tech.lideo.company.service;

import tech.lideo.company.model.Employee;
import tech.lideo.company.controller.dto.EmployeeDTO;
import tech.lideo.company.controller.dto.EmployeeDataDTO;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public interface EmployeeServiceDTO {
//
//    List<EmployeeDTO> findAll();
//
//    EmployeeDTO find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException;
//
//    Employee create(String firstName, String lastName, Long pesel) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException;
//
//    EmployeeDataDTO create(Long pesel, LocalDate startDate, LocalDate endDate, BigDecimal salary) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException;
//
//    String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException;
//
//    EmployeeDTO update(Long pesel, String newFirstName, String newLastName, Long newPesel) throws EmployeeNotFoundException, IllegalArgumentException;
}