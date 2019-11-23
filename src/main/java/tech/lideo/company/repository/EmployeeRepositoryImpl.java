package tech.lideo.company.repository;

import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;
import tech.lideo.company.shared.exceptions.NoEmployeesException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAll() throws NoEmployeesException {
        List<Employee> copiedList = new ArrayList<>();

        for (Employee e : employees) {
            copiedList.add(new Employee(
                    e.getId(),
                    e.getFirstName(),
                    e.getLastName(),
                    e.getPesel(),
                    e.getCreated()));
        }

        return copiedList;
    }

    @Override
    public Employee find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        validatePesel(pesel);

        Employee foundEmployee = employees.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);

        return new Employee(
                foundEmployee.getId(),
                foundEmployee.getFirstName(),
                foundEmployee.getLastName(),
                foundEmployee.getPesel(),
                foundEmployee.getCreated());
    }

    @Override
    public Employee create(String firstName, String lastName, Long pesel) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException {
        if (isNull(firstName)
                || firstName.length() == 0
                || isNull(lastName)
                || lastName.length() == 0) {
            throw new IllegalArgumentException();
        }
        validatePesel(pesel);

        boolean employeeExists = employees.stream()
                .anyMatch(e -> e.getPesel().equals(pesel));

        if (employeeExists) {
            throw new EmployeeAlreadyExistsException();
        }

        employees.add(new Employee(firstName, lastName, pesel));


        Employee createdEmployee = employees.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        return new Employee(
                createdEmployee.getId(),
                createdEmployee.getFirstName(),
                createdEmployee.getLastName(),
                createdEmployee.getPesel(),
                createdEmployee.getCreated());
    }

    @Override
    public String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        validatePesel(pesel);

        Employee employeeToDelete = employees.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);

        employees.removeIf(e -> e.getPesel().equals(pesel));

        return "Deleted employee: " + employeeToDelete;
    }

    @Override
    public Employee update(Long pesel, String newFirstName, String newLastName, Long newPesel) throws
            EmployeeNotFoundException, IllegalArgumentException {
        validatePesel(pesel);

        if (isNull(newFirstName) && isNull(newLastName) && isNull(newPesel)) {
            throw new IllegalArgumentException();
        }

        Employee employeeToUpdate = employees.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        boolean isEmployeeDeleted = employees.removeIf(e -> e.getPesel().equals(pesel));

        if (!isEmployeeDeleted) {
            throw new EmployeeNotFoundException();
        }

        Employee updatedEmployee = new Employee(employeeToUpdate.getId(),
                returnFirstName(employeeToUpdate.getFirstName(), newFirstName),
                returnLastName(employeeToUpdate.getLastName(), newLastName),
                returnPesel(employeeToUpdate.getPesel(), newPesel),
                employeeToUpdate.getCreated()
        );

        employees.add(updatedEmployee);

        Employee foundUpdatedEmployee = employees.stream()
                .filter(e -> e.getPesel().equals(returnPesel(pesel, newPesel)))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        return new Employee(
                foundUpdatedEmployee.getId(),
                foundUpdatedEmployee.getFirstName(),
                foundUpdatedEmployee.getLastName(),
                foundUpdatedEmployee.getPesel(),
                foundUpdatedEmployee.getCreated());
    }

    @Override
    public void clear() {
        employees.clear();

    }

    private void validatePesel(Long pesel) throws IllegalArgumentException {
        if (isNull(pesel)) {
            throw new IllegalArgumentException();
        }

        if (11 != pesel.toString().length()) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < pesel.toString().length(); i++) {
            if (!Character.isDigit(pesel.toString().charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        if (pesel.toString().charAt(0) == 0) {
            throw new IllegalArgumentException();
        }

        if (pesel.compareTo(0L) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private String returnFirstName(String firstName, String newFirstName) {
        if (isNull(newFirstName) || newFirstName.length() == 0) {
            return firstName;
        } else {
            return newFirstName;
        }
    }

    private String returnLastName(String lastName, String newLastName) {
        if (isNull(newLastName) || newLastName.length() == 0) {
            return lastName;
        } else {
            return newLastName;
        }
    }

    private Long returnPesel(Long pesel, Long newPesel) {
        try {
            validatePesel(newPesel);
            return newPesel;
        } catch (IllegalArgumentException ex) {
            return pesel;
        }
    }
}