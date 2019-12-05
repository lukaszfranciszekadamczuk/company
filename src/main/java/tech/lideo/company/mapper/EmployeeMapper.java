package tech.lideo.company.mapper;

import org.springframework.stereotype.Component;
import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;

@Component
public class EmployeeMapper {

    public Employee mapToEmployee(EmployeeDTO dto) {
        return new Employee(dto.getFirstName(), dto.getLastName(), dto.getPesel());
    }

    public EmployeeData mapToEmployeeData(EmployeeDTO dto) {
        return new EmployeeData(dto.getPesel(), dto.getDate(), dto.getSalary());
    }

    public EmployeeDTO mapToDTO(Employee model, EmployeeData employeeData) {
        return new EmployeeDTO(model.getFirstName(), model.getLastName(), model.getPesel(),
                employeeData.getEmployeeId(), employeeData.getDate(), employeeData.getSalary());
    }
}
