package tech.lideo.company.repository;

import com.google.gson.Gson;
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
    private Gson gson = new Gson();

    @Override
    public List<Employee> findAll() throws NoEmployeesException {
        List<Employee> copiedList = new ArrayList<>();

        for (Employee e : employees) {
            String empl = gson.toJson(e);
            copiedList.add(gson.fromJson(empl, Employee.class));
        }

        return copiedList;
    }

    @Override
    public Employee find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        validate(pesel);

        Employee employee = employees.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);

        String empl = gson.toJson(employee);

        return gson.fromJson(empl, Employee.class);
    }

    @Override
    public Employee create(Employee model) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException {
        validate(model);
        validate(model.getPesel());

        boolean employeeExists = employees.stream()
                .anyMatch(e -> e.getPesel().equals(model.getPesel()));

        if (employeeExists) {
            throw new EmployeeAlreadyExistsException();
        }

        employees.add(new Employee(model.getFirstName(), model.getLastName(), model.getPesel()));

        Employee employee = employees.stream()
                .filter(e -> e.getPesel().equals(model.getPesel()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        String empl = gson.toJson(employee);

        return gson.fromJson(empl, Employee.class);
    }

    @Override
    public String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {
        validate(pesel);

        Employee employeeToDelete = employees.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);

        employees.removeIf(e -> e.getPesel().equals(pesel));

        return "Deleted employee: " + employeeToDelete;
    }

    @Override
    public Employee update(Long pesel, Employee model) throws
            EmployeeNotFoundException, IllegalArgumentException {
        validate(pesel);
        validate(model.getPesel());

        Employee employeeToUpdate = employees.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        boolean isEmployeeDeleted = employees.removeIf(e -> e.getPesel().equals(pesel));

        if (!isEmployeeDeleted) {
            throw new EmployeeNotFoundException();
        }

        Employee updatedEmployee = new Employee(
                employeeToUpdate.getId(),
                returnFirstName(employeeToUpdate.getFirstName(), model.getFirstName()),
                returnLastName(employeeToUpdate.getLastName(), model.getLastName()),
                returnPesel(employeeToUpdate.getPesel(), model.getPesel()),
                employeeToUpdate.getCreated()
        );

        employees.add(updatedEmployee);

        Employee employee = employees.stream()
                .filter(e -> e.getPesel().equals(model.getPesel()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);

        String empl = gson.toJson(employee);

        return gson.fromJson(empl, Employee.class);
    }

    @Override
    public void clear() {
        employees.clear();

    }

    @Override
    public int size() {
        return employees.size();
    }

    @Override
    public void validate(Employee model) {
        if (isNull(model.getFirstName())
                || model.getFirstName().length() == 0
                || isNull(model.getLastName())
                || model.getLastName().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validate(Long pesel) throws IllegalArgumentException {
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
            validate(newPesel);
            return newPesel;
        } catch (IllegalArgumentException ex) {
            return pesel;
        }
    }
}