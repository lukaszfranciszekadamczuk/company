package tech.lideo.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lideo.company.mapper.MapperEmployee;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeDTO;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.EmployeeDataRepository;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.repository.exception.*;

import java.util.ArrayList;
import java.util.List;

@Service("service")
public class EmployeeService implements IEmployeeService {

    private List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    private EmployeeDTO employeeDTO;

//    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
    private EmployeeDataRepository employeeDataRepository;

//    @Autowired
    private MapperEmployee mapperEmployee = new MapperEmployee();

//    @Override
//    public List<EmployeeDTO> findAll() {
//        return employeeDTOList;
//    }

    @Override
    public EmployeeDTO create() throws EmployeeDataNotFoundException {
        if (!employeeDTO.getPesel().equals(employeeDTO.getEmployeeId()))
            throw new EmployeeDataNotFoundException();

        return mapperEmployee.getEmployeeDTO();
    }

//    @Override
//    public boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
//        return employeeRepository.delete(firstName, lastName, pesel);
//    }
//
//    @Override
//    public Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
//        return employeeRepository.find(firstName, lastName, pesel);
//    }
//
//    @Override
//    public Employee update(String actualFirstName, String actualLastName, String actualPesel,
//                           String newFirstName, String newLastName, String newPesel)
//            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
//        return employeeRepository.update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
//    }
}
