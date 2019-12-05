package tech.lideo.company.repository;

import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.exception.EmployeAlreadyHaveSalaryForThisDayException;
import tech.lideo.company.repository.exception.EmployeeDataAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeDataNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeDataRepository {

    List<EmployeeData> findAll();

    EmployeeData create(EmployeeData employeeData)
            throws EmployeePeselException, EmployeeDataNotFoundException, EmployeAlreadyHaveSalaryForThisDayException;

    boolean delete(String pesel, LocalDate date);

    EmployeeData find(String pesel, LocalDate date);

    EmployeeData update(String actualPesel, LocalDate actualDate, String newPesel, LocalDate newDate);

    void clear();

    int size();

    void validate(EmployeeData employeeData);

    void validate(String pesel) throws EmployeePeselException;
}
