package tech.lideo.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;
import tech.lideo.company.repository.exception.MissingReqiredUpdateArgumentsException;
import tech.lideo.company.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/company")
public class EmployeeController implements IEmployeeController {

    @Autowired
    EmployeeService service;

    @Override
    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return null;
    }

    @PostMapping("/create")
    public Employee create(@RequestParam("employee") Employee employee)
            throws EmployeePeselException, EmployeeNotFoundException, EmployeeAlreadyExistsException {
        return service.create(employee);
    }

    @Override
    @GetMapping("/delete")
    public boolean delete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                          @RequestParam("pesel") String pesel) throws EmployeeNotFoundException {
        return service.delete(firstName, lastName, pesel);
    }

    @Override
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                         @RequestParam("pesel") String pesel) throws EmployeeNotFoundException {
        return service.find(firstName, lastName, pesel);
    }

    @Override
    @PutMapping("/update")
    public Employee update(@RequestParam("actualFirstName") String actualFirstName,
                           @RequestParam("actualLastName") String actualLastName,
                           @RequestParam("actualPesel") String actualPesel,
                           @RequestParam("newFirstName") String newFirstName,
                           @RequestParam("newLastName") String newLastName,
                           @RequestParam("newPesel") String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
        return service.update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
    }
}
