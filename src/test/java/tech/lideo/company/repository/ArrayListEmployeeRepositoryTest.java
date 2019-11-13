package tech.lideo.company.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;
import tech.lideo.company.repository.exceptions.NoEmployeesException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListEmployeeRepositoryTest {

    private ArrayListEmployeeRepository repository;

    @Before
    public void setUp() {
        repository = new ArrayListEmployeeRepository();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void should_throw_exception_when_list_is_empty() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {

        //then
        assertThrows(NoEmployeesException.class, () -> repository.findAll());
    }

    @Test
    public void should_return_employee_list_when_employees_are_ont_the_lit() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employeeOne = new Employee("Jan", "Kowalski");
        Employee employeeTwo = new Employee("Marek", "Nowak");

        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        //then
        assertEquals(2, repository.findAll().size());
        assertEquals(employeeOne.getId(), repository.findAll().get(0).getId());
        assertEquals(employeeTwo.getId(), repository.findAll().get(1).getId());
    }

    @Test
    public void should_create_employee_when_given_valid_data() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");

        //when
        Employee createdEmployee = repository.create(employee);

        //then
        assertEquals(employee, createdEmployee);
    }

    @Test
    public void should_throw_exception_after_adding_employee_with_taken_id() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");

        //when
        repository.create(employee);

        //then
        assertThrows(EmployeeAlreadyExistsException.class, () -> {
            repository.create(employee);
        });
    }

    @Test
    public void should_return_exception_after_add_employee_without_required_argument() {
        //given
        Employee employee = new Employee(null, "Kowalski");

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            repository.create(employee);
        });
    }

    @Test
    public void should_delete_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");
        repository.create(employee);

        //when
        String deletedEmployee = repository.delete("Jan", "Kowalski");

        //then
        assertEquals("Deleted employee: " + "Employee{" +
                "id=" + employee.getId() +
                ", firstName='" + employee.getFirstName() + '\'' +
                ", lastName='" + employee.getLastName() + '\'' +
                ", created=" + employee.getCreated() +
                '}', deletedEmployee);
    }

    @Test
    public void should_return_exception_after_delete_employee_with_no_exists_data() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");
        repository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                repository.delete("Tadeusz", "Nowak"));
    }

    @Test
    public void should_find_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Henryk", "Sienkiewicz");
        repository.create(employee);

        //when
        List<Employee> foundEmployee = repository.find("Henryk", "Sienkiewicz");

        //then
        assertEquals(employee, foundEmployee.stream()
                .filter(e -> e.getFirstName().equals(employee.getFirstName()) &&
                        e.getLastName().equals(employee.getLastName()))
                .findFirst()
                .get()
        );
    }

    @Test
    public void should_return_exception_after_search_employee_with_no_exists_data() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Kaczor", "Donald");
        repository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                repository.find("Papa", "Smerf"));
    }

    @Test
    public void should_update_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jerry", "Łopata");
        String newLastName = "Shovel";
        repository.create(employee);

        //when
        Employee updatedEmployee = repository
                .update(employee.getFirstName(), employee.getLastName(), null, newLastName);

        //then
        assertEquals(employee.getId(), updatedEmployee.getId());
        assertEquals(employee.getFirstName(), updatedEmployee.getFirstName());
        assertEquals(newLastName, updatedEmployee.getLastName());
        assertEquals(employee.getCreated(), updatedEmployee.getCreated());
    }

    @Test
    public void should_return_exception_after_update_employee_with_no_exists_data() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Petru", "Swetru");
        String firstName = "Karabasz";
        String lastName = "Barabasz";
        repository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                repository.update(firstName, lastName, "Miś", "Uszatek"));
    }

    @Test
    public void should_return_exception_after_update_employee_with_illegal_argument() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Petru", "Swetru");
        repository.create(employee);

        //then
        assertThrows(IllegalArgumentException.class, () ->
                repository
                        .update(employee.getFirstName(), employee.getLastName(), null, null));
    }
}