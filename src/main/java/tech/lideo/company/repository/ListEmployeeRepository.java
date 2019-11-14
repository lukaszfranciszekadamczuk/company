package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class ListEmployeeRepository implements EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> findAll() throws NoEmployeesException {
        if (employeeList.isEmpty()) {
            throw new NoEmployeesException();
        }
        return employeeList;
    }

    @Override
    public Employee create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException {
        if (isNull(employee.getFirstName()) || isNull(employee.getLastName()))
            throw new IllegalArgumentException(
                    "All employee data are required");

        boolean isEmployeeExist = employeeList.stream()
                .anyMatch(e -> e.getId().equals(employee.getId()));

        if (isEmployeeExist)
            throw new EmployeeAlreadyExistsException();

        employeeList.add(employee);

        return employeeList.stream()
                .filter(e -> e.getId().equals(employee.getId()))
                .filter(e -> e.getFirstName().equals(employee.getFirstName()))
                .filter(e -> e.getLastName().equals(employee.getLastName()))
                .findFirst()
                .orElseThrow(
                        () -> new EmployeeNotFoundException()
                );
    }

    @Override
    public boolean delete(String firstName, String lastName) throws EmployeeNotFoundException {
        if (isNull(firstName) || isNull(lastName))
            throw new IllegalArgumentException(
                    "All employee data are required");

        Optional.ofNullable(
                employeeList.stream()
                        .filter(e -> e.getFirstName().equals(firstName))
                        .filter(e -> e.getLastName().equals(lastName))
                        .collect(Collectors.toList()))
                .filter(list -> !list.isEmpty())
                .orElseThrow(
                        () -> new EmployeeNotFoundException()
                );

        return employeeList
                .removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));
    }

    @Override
    public List<Employee> find(String firstName, String lastName) throws EmployeeNotFoundException {
        if (isNull(firstName) || isNull(lastName))
            throw new IllegalArgumentException(
                    "All employee data are required");

        return Optional.ofNullable(
                employeeList.stream()
                        .filter(e -> e.getFirstName().equals(firstName))
                        .filter(e -> e.getLastName().equals(lastName))
                        .collect(Collectors.toList()))
                .filter(list -> !list.isEmpty())
                .orElseThrow(
                        () -> new EmployeeNotFoundException()
                );
    }

    @Override
    public Employee update(String firstName, String lastName, String newFirstName, String newLastName)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
        if (isNull(firstName) || isNull(lastName))
            throw new IllegalArgumentException(
                    "All employee data are required");

        if (isNull(newFirstName) && isNull(newLastName))
            throw new MissingReqiredUpdateArgumentsException(
                    "Required to provide at least one parameter of the employee being updated");

        Employee employeeToUpdate = employeeList.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(() ->
                        new EmployeeNotFoundException());

        int index = employeeList.indexOf(employeeToUpdate);

        if (isNull(newFirstName))
            employeeToUpdate.setFirstName(firstName);
        else employeeToUpdate.setFirstName(newFirstName);

        if (isNull(newLastName))
            employeeToUpdate.setLastName(lastName);
        else employeeToUpdate.setLastName(newLastName);

        employeeList.set(index, employeeToUpdate);

        return employeeList.stream()
                .filter(e -> e.getFirstName().equals(employeeToUpdate.getFirstName()))
                .filter(e -> e.getLastName().equals(employeeToUpdate.getLastName()))
                .findFirst()
                .orElseThrow(() ->
                        new EmployeeNotFoundException());
    }
}
