package tech.lideo.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.lideo.company.model.Employee;
import tech.lideo.company.service.EmployeeServiceImpl;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeServiceImpl service;

    @GetMapping("/findAll")
    @Override
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/find/{pesel}")
    @Override
    public Employee find(@PathVariable Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        return service.find(pesel);
    }

    @PostMapping("/create/{firstName}/{lastName}/{pesel}")
    @Override
    public Employee create(@PathVariable String firstName, @PathVariable String lastName, @PathVariable Long pesel) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException {
        return service.create(firstName, lastName, pesel);
    }

    @DeleteMapping("/delete/{pesel}")
    @Override
    public String delete(@PathVariable Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        return service.delete(pesel);
    }

    @PutMapping("/update/{pesel}/{newFirstName}/{newLastName}/{newPesel}")
    @Override
    public Employee update(Long pesel, String newFirstName, String newLastName, Long newPesel) throws EmployeeNotFoundException, IllegalArgumentException {
        return service.update(pesel, newFirstName, newLastName, newPesel);
    }
}