package tech.lideo.company.service.mappers;

import org.springframework.stereotype.Component;
import tech.lideo.company.dto.EmployeeDataDTO;
import tech.lideo.company.model.EmployeeData;

@Component
public class EmployeeDataMapper {
    public EmployeeData mapToModel(EmployeeDataDTO dto) {
        return new EmployeeData(
                dto.getPesel(),
                dto.getDate(),
                dto.getSalary());
    }

    public EmployeeDataDTO mapToDTO(EmployeeData model) {
        return new EmployeeDataDTO(
                model.getPesel(),
                model.getDate(),
                model.getSalary());
    }
}