package tech.lideo.company.repository;

import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;
import tech.lideo.company.repository.exceptions.NoEmployeesException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Repository
public class ArrayListEmployeeRepository implements EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        if (employeeList.isEmpty()) {
            throw new NoEmployeesException();
        }
        return employeeList;
    }

    @Override
    public List<Employee> find(String firstName, String lastName) throws EmployeeNotFoundException {
        if (isNull(firstName) && isNull(lastName)) {
            throw new IllegalArgumentException();
        }

        List<Employee> searchedEmployees = employeeList.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .collect(Collectors.toList());
        if (searchedEmployees.isEmpty()) {
            throw new EmployeeNotFoundException();
        }

        return searchedEmployees;
    }

    @Override
    public String create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException {
        if (isNull(employee.getFirstName()) || isNull(employee.getLastName())) {
            throw new IllegalArgumentException();
        }

        boolean employeeExists = employeeList.stream()
                .anyMatch(e -> e.getId().equals(employee.getId()));

        if (employeeExists) {
            throw new EmployeeAlreadyExistsException();
        }

        employeeList.add(employee);

        return "Created employee: " + employeeList.stream()
                .filter(e -> e.getId().equals(employee.getId()))
                .filter(e -> e.getFirstName().equals(employee.getFirstName()))
                .filter(e -> e.getLastName().equals(employee.getLastName()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public String delete(String firstName, String lastName) throws EmployeeNotFoundException {
        if (isNull(firstName) && isNull(lastName)) {
            throw new IllegalArgumentException();
        }

        Employee employeeToDelete = employeeList.stream()
                .filter(e -> e.getFirstName().equals(firstName))
                .filter(e -> e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        employeeList.removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));

        return "Deleted employee: " + employeeToDelete;
    }

    @Override
    public String update(String firstName, String lastName, String newFirstName, String newLastName) throws EmployeeNotFoundException {
        if (isNull(firstName) && isNull(lastName)) {
            throw new IllegalArgumentException();
        }
        if (isNull(newFirstName) && isNull(newLastName)) {
            throw new IllegalArgumentException();
        }

        Employee employeeToUpdate = employeeList.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        boolean isEmployeeDeleted = employeeList.removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));

        if (!isEmployeeDeleted) {
            throw new EmployeeNotFoundException();
        }

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(employeeToUpdate.getId());
        if (nonNull(newFirstName)) {
            updatedEmployee.setFirstName(newFirstName);
        } else {
            updatedEmployee.setFirstName(employeeToUpdate.getFirstName());
        }
        if (nonNull(newLastName)) {
            updatedEmployee.setLastName(newLastName);
        } else {
            updatedEmployee.setLastName(employeeToUpdate.getLastName());
        }
        updatedEmployee.setCreated(employeeToUpdate.getCreated());

        employeeList.add(updatedEmployee);

        Employee updatedEmployeeResult = employeeList.stream()
                .filter(e -> e.getFirstName().equals(updatedEmployee.getFirstName()) && e.getLastName().equals(updatedEmployee.getLastName()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        return "Updated employee: " + employeeToUpdate + " to: " + updatedEmployeeResult;
    }
}