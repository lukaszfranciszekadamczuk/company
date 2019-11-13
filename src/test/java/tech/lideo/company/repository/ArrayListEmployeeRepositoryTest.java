package tech.lideo.company.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListEmployeeRepositoryTest {

    private ArrayListEmployeeRepository arrayListEmployeeRepository;

    @Before
    public void setUp() {
        arrayListEmployeeRepository = new ArrayListEmployeeRepository();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void should_return_employee_list() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employeeOne = new Employee("Jan", "Kowalski");
        Employee employeeTwo = new Employee("Marek", "Nowak");

        //when
        arrayListEmployeeRepository.create(employeeOne);
        arrayListEmployeeRepository.create(employeeTwo);

        //then
        assertEquals(2, arrayListEmployeeRepository.findAll().size());
        assertEquals(employeeOne.getId(), arrayListEmployeeRepository.findAll().get(0).getId());
        assertEquals(employeeTwo.getId(), arrayListEmployeeRepository.findAll().get(1).getId());
    }

    @Test
    public void should_create_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");

        //when
        String createEmployee = arrayListEmployeeRepository.create(employee);

        //then
        assertEquals("Created employee: " + "Employee{" +
                "id=" + employee.getId() +
                ", firstName='" + employee.getFirstName() + '\'' +
                ", lastName='" + employee.getLastName() + '\'' +
                ", created=" + employee.getCreated() +
                '}', createEmployee);
    }

    @Test
    public void should_return_exception_after_add_employee_with_the_same_id() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");

        //when
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeAlreadyExistsException.class, () -> {
            arrayListEmployeeRepository.create(employee);
        });
    }

    @Test
    public void should_return_exception_after_add_employee_without_required_argument() {
        //given
        Employee employee = new Employee(null, "Kowalski");

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            arrayListEmployeeRepository.create(employee);
        });
    }

    @Test
    public void should_delete_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");
        arrayListEmployeeRepository.create(employee);

        //when
        String deletedEmployee = arrayListEmployeeRepository.delete("Jan", "Kowalski");

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
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                arrayListEmployeeRepository.delete("Tadeusz", "Nowak"));
    }

    @Test
    public void should_find_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Henryk", "Sienkiewicz");
        arrayListEmployeeRepository.create(employee);

        //when
        List<Employee> foundEmployee = arrayListEmployeeRepository.find("Henryk", "Sienkiewicz");

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
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                arrayListEmployeeRepository.find("Papa", "Smerf"));
    }

    @Test
    public void should_update_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jerry", "Łopata");
        String newLastName = "Shovel";
        arrayListEmployeeRepository.create(employee);

        //when
        String updateEmployee = arrayListEmployeeRepository
                .update(employee.getFirstName(), employee.getLastName(), null, newLastName);

        //then
        assertEquals("Updated employee: " + "Employee{" +
                        "id=" + employee.getId() +
                        ", firstName='" + employee.getFirstName() + '\'' +
                        ", lastName='" + employee.getLastName() + '\'' +
                        ", created=" + employee.getCreated() +
                        '}'
                        + " to: " + "Employee{" +
                        "id=" + employee.getId() +
                        ", firstName='" + employee.getFirstName() + '\'' +
                        ", lastName='" + newLastName + '\'' +
                        ", created=" + employee.getCreated() +
                        '}',
                updateEmployee);
    }

    @Test
    public void should_return_exception_after_update_employee_with_no_exists_data() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Petru", "Swetru");
        String firstName = "Karabasz";
        String lastName = "Barabasz";
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                arrayListEmployeeRepository.update(firstName, lastName, "Miś", "Uszatek"));
    }

    @Test
    public void should_return_exception_after_update_employee_with_illegal_argument() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Petru", "Swetru");
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(IllegalArgumentException.class, () ->
                arrayListEmployeeRepository
                        .update(employee.getFirstName(), employee.getLastName(), null, null));
    }
}