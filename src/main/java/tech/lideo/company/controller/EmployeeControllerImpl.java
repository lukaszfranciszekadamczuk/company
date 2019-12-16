package tech.lideo.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.service.EmployeeService;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements EmployeeController {
//
//    @Autowired
//    private EmployeeService service;
//
//    @Override
//    @GetMapping("/findAll")
//    public List<EmployeeDTO> findAll() {
//
//        return service.findAll();
//    }
//
//    @GetMapping("/find/{pesel}")
//    @Override
//    public EmployeeDTO find(@PathVariable Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
//
//        return service.find(pesel);
//    }
//
//    @PostMapping("/create")
//    @Override
//    public EmployeeDTO create(@RequestBody EmployeeDTO dto) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException {
//
//        return service.create(dto);
//    }
//
//    @DeleteMapping("/delete/{pesel}")
//    @Override
//    public String delete(@PathVariable Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
//
//        return service.delete(pesel);
//    }
//
//    @PutMapping("/update/{pesel}")
//    @Override
//    public EmployeeDTO update(@PathVariable Long pesel, @RequestBody EmployeeDTO dto) throws EmployeeNotFoundException, IllegalArgumentException {
//
//        return service.update(pesel, dto);
//    }
}