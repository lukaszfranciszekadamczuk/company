package tech.lideo.company.controller;

import tech.lideo.company.dto.EmployeeDataDTO;
import tech.lideo.company.shared.exceptions.EmployeeDataAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeDataNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeDataController {

    List<EmployeeDataDTO> findAll();

    EmployeeDataDTO find(Long pesel, LocalDate date) throws EmployeeDataNotFoundException;

    EmployeeDataDTO create(EmployeeDataDTO dto) throws EmployeeDataAlreadyExistsException, EmployeeDataNotFoundException;

    String delete(Long pesel, LocalDate date) throws EmployeeDataNotFoundException;

    EmployeeDataDTO update(Long pesel, LocalDate date, EmployeeDataDTO dto) throws EmployeeDataNotFoundException;
}