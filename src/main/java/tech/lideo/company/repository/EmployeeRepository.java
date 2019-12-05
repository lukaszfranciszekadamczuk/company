package tech.lideo.company.repository;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;
import tech.lideo.company.repository.exception.MissingReqiredUpdateArgumentsException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();
    private List<Employee> employeeCopyList = new ArrayList<>();
    private Gson gson = new Gson();

    private String firstName;
    private String lastName;
    private String pesel;

    @Override
    public List<Employee> findAll() {
        for (Employee e : employeeList) {
            String employeeToJson = gson.toJson(e);
            employeeCopyList.add(gson.fromJson(employeeToJson, Employee.class));
        }
        return employeeCopyList;
    }

    @Override
    public Employee create(Employee employee)
            throws EmployeeAlreadyExistsException, EmployeeNotFoundException, EmployeePeselException {
        validate(employee);
        validate(employee.getPesel());

        boolean isEmployeeExist = employeeList.stream()
                .anyMatch(e -> e.getPesel().equals(employee.getPesel()));

        if (isEmployeeExist)
            throw new EmployeeAlreadyExistsException();

        employeeList.add(employee);

        return employeeList.stream()
                .filter(e -> e.getId().equals(employee.getId()))
                .filter(e -> e.getFirstName().equals(employee.getFirstName()))
                .filter(e -> e.getLastName().equals(employee.getLastName()))
                .filter(e -> e.getPesel().equals(employee.getPesel()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
        if (isNull(firstName) || isNull(lastName) || isNull(pesel))
            throw new IllegalArgumentException(
                    "All employee data are required");

        employeeList.stream()
                .filter(e -> e.getFirstName().equals(firstName))
                .filter(e -> e.getLastName().equals(lastName))
                .filter(e -> e.getPesel().equals(pesel))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        return employeeList
                .removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName) && e.getPesel().equals(pesel));
    }

    @Override
    public Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
        if (isNull(firstName) || isNull(lastName) || isNull(pesel))
            throw new IllegalArgumentException(
                    "All employee data are required");

        return employeeList.stream()
                .filter(e -> e.getFirstName().equals(firstName))
                .filter(e -> e.getLastName().equals(lastName))
                .filter(e -> e.getPesel().equals(pesel))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee update(String actualFirstName, String actualLastName, String actualPesel,
                           String newFirstName, String newLastName, String newPesel)
            throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
        if (isNull(actualFirstName) || isNull(actualLastName) || isNull(actualPesel))
            throw new IllegalArgumentException(
                    "All employee data are required");

        if (isNull(newFirstName) && isNull(newLastName) && isNull(newPesel))
            throw new MissingReqiredUpdateArgumentsException(
                    "Required to provide at least one parameter of the employee being updated");

        Employee employeeToUpdate = employeeList.stream()
                .filter(e -> e.getFirstName().equals(actualFirstName)
                        && e.getLastName().equals(actualLastName) && e.getPesel().equals(actualPesel))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        int index = employeeList.indexOf(employeeToUpdate);

        employeeList.removeIf(e -> e.getFirstName().equals(firstName)
                && e.getLastName().equals(lastName) && e.getPesel().equals(pesel));

        if (isNull(newFirstName))
            firstName = actualFirstName;
        else firstName = newFirstName;

        if (isNull(newLastName))
            lastName = actualLastName;
        else lastName = newLastName;

        if (isNull(newPesel))
            pesel = actualPesel;
        else pesel = newPesel;

        Employee newUpdateEmployee = new Employee(firstName, lastName, pesel);


        employeeList.set(index, newUpdateEmployee);

        return employeeList.stream()
                .filter(e -> e.getFirstName().equals(newUpdateEmployee.getFirstName()))
                .filter(e -> e.getLastName().equals(newUpdateEmployee.getLastName()))
                .filter(e -> e.getPesel().equals(newUpdateEmployee.getPesel()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void clear() {
        employeeCopyList.clear();

    }

    @Override
    public int size() {
        return employeeCopyList.size();
    }

    @Override
    public void validate(Employee employee) {
        if (isNull(employee.getFirstName()) || isNull(employee.getLastName()) || isNull(employee.getPesel()))
            throw new IllegalArgumentException(
                    "All employee data are required");
    }

    @Override
    public void validate(String pesel) throws EmployeePeselException {
        if (pesel.length() != 11)
            throw new EmployeePeselException(
                    "Employee pesel should have 11 characters"
            );
    }
}
