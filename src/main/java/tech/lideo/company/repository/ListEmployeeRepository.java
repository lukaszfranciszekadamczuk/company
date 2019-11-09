package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListEmployeeRepository implements EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee create(Employee employee) {

        employeeList.stream().
                filter(e -> !e.getId().equals(employee.getId()))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Employee with given Id: " + employee.getId() + " is alrady exist")
                );

        employeeList.add(employee);
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Employee find(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }
}
