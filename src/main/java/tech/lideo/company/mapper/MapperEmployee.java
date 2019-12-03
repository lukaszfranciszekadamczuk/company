package tech.lideo.company.mapper;

import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeDTO;
import tech.lideo.company.model.EmployeeData;

public class MapperEmployee {

    public EmployeeDTO getEmployeeDTO(Employee employee, EmployeeData employeeData){
       return new EmployeeDTO(employee.getFirstName(),
               employee.getLastName(),
               employee.getPesel(),
               employeeData.getEmployeeId(),
               employeeData.getSalary());
    }
}
