package tech.lideo.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lideo.company.model.Employee;
import tech.lideo.company.controller.dto.EmployeeDTO;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.controller.dto.EmployeeDataDTO;
import tech.lideo.company.repository.EmployeeDataRepository;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceDTOImpl implements EmployeeServiceDTO {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//    @Autowired
//    private EmployeeDataRepository employeeDataRepository;
//
//    @Override
//    public List<EmployeeDTO> findAll() {
//        List<EmployeeDTO> emplDTO = new ArrayList<>();
//
//        List<Employee> empl = employeeRepository.findAll();
//        List<EmployeeData> dataList = employeeDataRepository.findAll();
//
//        empl.forEach(e -> emplDTO.add(modelToDTO(e, dataList.stream()
//                .filter(data -> data.getPesel().equals(e.getPesel()))
//                .collect(Collectors.toList()))));
//
//        return emplDTO;
//    }
//
//    @Override
//    public EmployeeDTO find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
//        Employee empl = employeeRepository.find(pesel);
//        List<EmployeeData> dataList = employeeDataRepository.find(pesel);
//
//        return modelToDTO(empl, dataList);
//    }
//
//    @Override
//    public Employee create(String firstName, String lastName, Long pesel) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException {
//        return employeeRepository.create(firstName, lastName, pesel);
//    }
//
//    @Override
//    public EmployeeDataDTO create(Long pesel, LocalDate startDate, LocalDate endDate, BigDecimal salary) throws EmployeeNotFoundException, IllegalArgumentException {
//        Employee employee = employeeRepository.find(pesel);
//        EmployeeData data = employeeDataRepository.create(employee.getId(), startDate, endDate, salary, pesel);
//
//        return dataToDTO(data);
//    }
//
//    @Override
//    public String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
//        employeeDataRepository.delete(pesel);
//        return employeeRepository.delete(pesel);
//    }
//
//    @Override
//    public EmployeeDTO update(Long pesel, String newFirstName, String newLastName, Long newPesel) throws EmployeeNotFoundException, IllegalArgumentException {
//
//        return null;
////        return repository.update(pesel, newFirstName, newLastName, newPesel);
//    }
//
//    private EmployeeDTO modelToDTO(Employee empl, List<EmployeeData> dataList) {
//
//        return new EmployeeDTO(
//                empl.getFirstName(),
//                empl.getLastName(),
//                empl.getPesel(),
//                dataList.stream()
//                        .map(data -> dataToDTO(data))
//                        .collect(Collectors.toList())
//        );
//    }
//
//    private EmployeeDataDTO dataToDTO(EmployeeData model) {
//        return new EmployeeDataDTO(model.getStartDate(), model.getEndDate(), model.getSalary());
//    }
}
