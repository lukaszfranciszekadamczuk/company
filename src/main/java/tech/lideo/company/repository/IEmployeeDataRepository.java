package tech.lideo.company.repository;

import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.exception.EmployeeDataAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeDataNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;

import java.util.List;

public interface IEmployeeDataRepository {

    List<EmployeeData> findAll();

    EmployeeData create(EmployeeData employeeData)
            throws EmployeePeselException, EmployeeDataAlreadyExistsException, EmployeeDataNotFoundException;

    boolean delete (String employeeId);

    EmployeeData find(String employeeId);

    EmployeeData update(String actualEmployeeId, String newEmployeeId);
}
