package tech.lideo.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.model.EmployeeWithEmployeeData;
import tech.lideo.company.repository.EmployeeDataRepository;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.repository.exception.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Service("service")
public class EmployeeService implements IEmployeeService {

    private List<EmployeeWithEmployeeData> employeeWithEmployeeDataList= new ArrayList<>();
    private EmployeeWithEmployeeData employeeWithEmployeeData;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeDataRepository employeeDataRepository;

    @Override
    public List<EmployeeWithEmployeeData> findAll() {
        return employeeWithEmployeeDataList;
    }

    @Override
    public EmployeeWithEmployeeData create(Employee employee, EmployeeData employeeData)
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException,
            EmployeePeselException, EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException {
        if (!employee.getPesel().equals(employeeData.getEmployeeId()))
            throw new EmployeeDataNotFoundException();

        employeeWithEmployeeData =
                new EmployeeWithEmployeeData(employeeRepository.create(employee), employeeDataRepository.create(employeeData));

        employeeWithEmployeeDataList.add(employeeWithEmployeeData);

        return employeeWithEmployeeDataList.stream()
                .filter(e->e.getEmployee().equals(employee))
                .filter(e->e.getEmployeeData().equals(employeeData))
                .findFirst()
                .get();
    }

    @Override
    public boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
        return employeeRepository.delete(firstName, lastName, pesel);
    }

    @Override
    public Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
        return employeeRepository.find(firstName, lastName, pesel);
    }

    @Override
    public Employee update(String actualFirstName, String actualLastName, String actualPesel,
                           String newFirstName, String newLastName, String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
        return employeeRepository.update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
    }
}
