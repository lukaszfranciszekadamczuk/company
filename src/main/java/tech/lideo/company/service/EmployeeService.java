package tech.lideo.company.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.mapper.EmployeeMapper;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.EmployeeDataRepository;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.repository.exception.*;
import tech.lideo.company.service.exception.EmployeeIncompatibleWithEmployeeData;

import java.util.ArrayList;
import java.util.List;

@Service("service")
public class EmployeeService implements IEmployeeService {

    private List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    private List<EmployeeDTO> employeeDTOCopyList = new ArrayList<>();
    private Gson gson = new Gson();

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Override
    public List<EmployeeDTO> findAll() {
        for (EmployeeDTO employeeDTO : employeeDTOList) {
            String employeeToJson = gson.toJson(employeeDTO);
            employeeDTOCopyList.add(gson.fromJson(employeeToJson, EmployeeDTO.class));
        }
        return employeeDTOCopyList;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) throws EmployeePeselException, EmployeeNotFoundException,
            EmployeeAlreadyExistsException, EmployeeDataNotFoundException,
            EmployeeIncompatibleWithEmployeeData, EmployeAlreadyHaveSalaryForThisDayException {

        validate(dto);

        Employee employee = employeeRepository.create(mapper.mapToEmployee(dto));
        EmployeeData employeeData = employeeDataRepository.create(mapper.mapToEmployeeData(dto));

        EmployeeDTO employeeDTO = mapper.mapToDTO(employee, employeeData);

        employeeDTOList.add(employeeDTO);

        return employeeDTO;
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

    @Override
    public void clear() {
        employeeDTOCopyList.clear();
    }

    @Override
    public int size() {
        return employeeDTOCopyList.size();
    }

    @Override
    public void validate(EmployeeDTO dto) throws EmployeeIncompatibleWithEmployeeData {
        if (!dto.getPesel().equals(dto.getEmployeeId()))
            throw new EmployeeIncompatibleWithEmployeeData();
    }
}
