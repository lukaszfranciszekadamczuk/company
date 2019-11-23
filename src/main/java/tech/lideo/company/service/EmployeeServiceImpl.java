package tech.lideo.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        return repository.find(pesel);
    }

    @Override
    public Employee create(String firstName, String lastName, Long pesel) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException {
        return repository.create(firstName, lastName, pesel);
    }

    @Override
    public String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        return repository.delete(pesel);
    }

    @Override
    public Employee update(Long pesel, String newFirstName, String newLastName, Long newPesel) throws EmployeeNotFoundException, IllegalArgumentException {
        return repository.update(pesel, newFirstName, newLastName, newPesel);
    }
}
