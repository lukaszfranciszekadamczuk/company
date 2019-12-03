package tech.lideo.company.mapper;

import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeDTO;

public class EmployeeMapper {

    public Employee mapToModel(EmployeeDTO dto) {
        return new Employee(dto.getFirstName(), dto.getLastName(), dto.getPesel());
    }

    public EmployeeDTO mapToDTO(Employee model) {
        return new EmployeeDTO(model.getFirstName(), model.getLastName(), model.getPesel());
    }
}
