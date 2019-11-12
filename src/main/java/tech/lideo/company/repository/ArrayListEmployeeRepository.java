package tech.lideo.company.repository;

import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Repository
public class ArrayListEmployeeRepository implements EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException {
        if (isNull(employee.getId()) || isNull(employee.getFirstName()) || isNull(employee.getLastName())) {
            throw new IllegalArgumentException();
        }

        boolean employeeExists = employeeList.stream()
                .anyMatch(e -> e.getId().equals(employee.getId()));

        if (employeeExists) {
            throw new EmployeeAlreadyExistsException();
        }

        employeeList.add(employee);

        return employeeList.stream()
                .findFirst()
                .filter(e -> e.getId().equals(employee.getId()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public boolean delete(Long id) {
        if (isNull(id)) {
            throw new IllegalArgumentException();
        }

        return employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Employee find(Long id) throws EmployeeNotFoundException {
        return employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee update(Employee newEmployeeData) throws EmployeeNotFoundException {
        if (isNull(newEmployeeData.getId()) && isNull(newEmployeeData.getFirstName()) && isNull(newEmployeeData.getLastName())) {
            throw new IllegalArgumentException();
        }

        boolean employeeExists = employeeList.stream()
                .anyMatch(e -> e.getId().equals(newEmployeeData.getId()));

        if (!employeeExists) {
            throw new EmployeeNotFoundException();
        }

        Employee employeeToUpdate = employeeList.stream().filter(e -> e.getId().equals(newEmployeeData.getId())).collect(Collectors.toList()).get(0);
        employeeList.removeIf(e -> e.getId().equals(newEmployeeData.getId()));
        employeeToUpdate.setFirstName(newEmployeeData.getFirstName());
        employeeToUpdate.setLastName(newEmployeeData.getLastName());

        employeeList.add(employeeToUpdate);

        return employeeList.stream()
                .filter(e -> e.getId().equals(newEmployeeData.getId()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }
}