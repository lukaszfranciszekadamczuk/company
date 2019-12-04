package tech.lideo.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.lideo.company.dto.EmployeeDataDTO;
import tech.lideo.company.service.EmployeeDataService;
import tech.lideo.company.shared.exceptions.EmployeeDataAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeDataNotFoundException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee-data")
public class EmployeeDataControllerImpl implements EmployeeDataController {

    @Autowired
    private EmployeeDataService service;

    @Override
    @GetMapping("/findAll")
    public List<EmployeeDataDTO> findAll() {

        return service.findAll();
    }

    @GetMapping("/find/{pesel}/{date}")
    @Override
    public EmployeeDataDTO find(@PathVariable Long pesel, @PathVariable LocalDate date) throws EmployeeDataNotFoundException, IllegalArgumentException {

        return service.find(pesel, date);
    }

    @PostMapping("/create")
    @Override
    public EmployeeDataDTO create(@RequestBody EmployeeDataDTO dto) throws EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException {

        return service.create(dto);
    }

    @DeleteMapping("/delete/{pesel}/{date}")
    @Override
    public String delete(@PathVariable Long pesel, @PathVariable LocalDate date) throws EmployeeDataNotFoundException, IllegalArgumentException {

        return service.delete(pesel, date);
    }

    @PutMapping("/update/{pesel}/{date}")
    @Override
    public EmployeeDataDTO update(@PathVariable Long pesel, @PathVariable LocalDate date, @RequestBody EmployeeDataDTO dto) throws EmployeeDataNotFoundException {

        return service.update(pesel, date, dto);
    }
}