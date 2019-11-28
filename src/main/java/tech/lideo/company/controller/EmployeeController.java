package tech.lideo.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.model.EmployeeDTO;
import tech.lideo.company.repository.exception.*;
import tech.lideo.company.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeController implements IEmployeeController {

    @Autowired
    EmployeeService service;

    @Override
    @GetMapping("/findAll")
    public List<EmployeeDTO> findAll() {

        return service.findAll();
    }

    @PostMapping("/create")
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO)
            throws EmployeePeselException, EmployeeNotFoundException,
            EmployeeAlreadyExistsException, EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException {
        return service.create(employeeDTO.getEmployee(), employeeDTO.getEmployeeData());
    }

    @Override
    @DeleteMapping("/delete/{firstName}/{lastName}/{pesel}")
    public boolean delete(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String pesel)
            throws EmployeeNotFoundException {
        return service.delete(firstName, lastName, pesel);
    }

    @Override
    @GetMapping("/find/{firstName}/{lastName}/{pesel}")
    public Employee find(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String pesel)
            throws EmployeeNotFoundException {
        return service.find(firstName, lastName, pesel);
    }

    @Override
    @PutMapping("/update/{actualFirstName}/{actualLastName}/{actualPesel}/{newFirstName}/{newLastName}/{newPesel}")
    public Employee update(
            @PathVariable String actualFirstName, @PathVariable String actualLastName, @PathVariable String actualPesel,
            @PathVariable String newFirstName, @PathVariable String newLastName, @PathVariable String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
        return service.update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
    }
}
