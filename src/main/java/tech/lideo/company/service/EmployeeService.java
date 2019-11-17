package tech.lideo.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.IEmployeeRepository;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;
import tech.lideo.company.repository.exception.MissingReqiredUpdateArgumentsException;

import java.util.List;

@Service("service")
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee create(Employee employee)
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        return repository.create(employee);
    }

    @Override
    public boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
        return repository.delete(firstName, lastName, pesel);
    }

    @Override
    public Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
        return repository.find(firstName, lastName, pesel);
    }

    @Override
    public Employee update(String actualFirstName, String actualLastName, String actualPesel,
                           String newFirstName, String newLastName, String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
        return repository.update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
    }
}
