package tech.lideo.company.service.mappers;

import org.springframework.stereotype.Component;
import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.model.Employee;

@Component
public class EmployeeMapper {
    public Employee mapToModel(EmployeeDTO dto) {
        return new Employee(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPesel());
    }

    public EmployeeDTO mapToDTO(Employee model) {
        return new EmployeeDTO(
                model.getFirstName(),
                model.getLastName(),
                model.getPesel());
    }
}