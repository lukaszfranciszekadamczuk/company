package tech.lideo.company.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.lideo.company.model.Employee;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListEmployeeRepositoryTest {

    private ListEmployeeRepository listEmployeeRepository;

    @Before
    public void setUp() throws Exception {
        listEmployeeRepository = new ListEmployeeRepository();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void should_return_empty_employee_list() {
        //then
        assertThrows(NoEmployeesException.class, () ->
                listEmployeeRepository.findAll());
    }

    @Test
    public void should_return_employee_list() throws EmployeeNotFoundException, EmployeeAlreadyExistsException, NoEmployeesException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //when
        int listSize = listEmployeeRepository.findAll().size();

        //then
        assertEquals(2, listSize);
        assertEquals(firstEmployee.getId(), listEmployeeRepository.findAll().get(0).getId());
        assertEquals(secondEmployee.getId(), listEmployeeRepository.findAll().get(1).getId());
    }

    @Test
    public void should_create_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");

        //when
        Employee createEmployee = listEmployeeRepository.create(employee);

        //then
        assertEquals(employee, createEmployee);
    }

    @Test
    public void should_return_exception_after_create_employee_with_the_same_id()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");

        //when
        listEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeAlreadyExistsException.class, () -> listEmployeeRepository.create(employee));
    }

    @Test
    public void should_return_exception_after_create_employee_with_no_reqired_data() {
        //given
        Employee employee = new Employee(null, "Kowalski");

        //then
        assertThrows(IllegalArgumentException.class, () -> listEmployeeRepository.create(employee));
    }

    @Test
    public void should_delete_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, NoEmployeesException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //when
        boolean isEmployeeDelete = listEmployeeRepository.delete("Marek", "Nowak");

        //then
        assertEquals(true, isEmployeeDelete);
        assertEquals(1, listEmployeeRepository.findAll().size());
    }

    @Test
    public void should_return_exception_after_delete_employee_with_no_reqired_data()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(employee);

        //then
        assertThrows(IllegalArgumentException.class, () -> listEmployeeRepository.delete(null, "Kolawski"));
    }

    @Test
    public void should_return_exception_after_delete_no_exist_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //then
        assertThrows(EmployeeNotFoundException.class, () -> listEmployeeRepository.delete("Rafał", "Majka"));
    }

    @Test
    public void should_find_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //when
        List<Employee> searchingEmployee = listEmployeeRepository.find("Marek", "Nowak");

        //then
        assertEquals(secondEmployee, searchingEmployee.get(0));
    }

    @Test
    public void should_return_exception_after_search_no_exist_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                listEmployeeRepository.find("Paweł", "Majak"));
    }

    @Test
    public void should_return_exception_after_search_by_no_reqired_data()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //then
        assertThrows(IllegalArgumentException.class, () ->
                listEmployeeRepository.find(null, "Nowak"));
    }

    @Test
    public void should_update_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, MissingReqiredUpdateArgumentsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //when
        Employee updateEmployee = listEmployeeRepository
                .update("Marek", "Nowak", "Tadeusz", "Nalepa");

        //then
        assertEquals(secondEmployee, updateEmployee);
    }

    @Test
    public void should_return_exception_after_update_no_exist_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //then
        assertThrows(EmployeeNotFoundException.class, ()->
        listEmployeeRepository
                .update("Roman", "Kostrzewa", "Tadeusz", "Nalepa"));
    }

    @Test
    public void should_return_exception_after_update_employee_without_requred_argument()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //then
        assertThrows(IllegalArgumentException.class, ()->
                listEmployeeRepository
                        .update(null, "Nowak", "Tadeusz", "Nalepa"));
    }

    @Test
    public void should_return_exception_after_update_employee_with_missing_required_argument()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

        //then
        assertThrows(MissingReqiredUpdateArgumentsException.class, ()->
                listEmployeeRepository
                        .update("Marek", "Nowak", null, null));
    }

    @Test
    public void should_update_employee_with_at_least_one_reqired_argument()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, MissingReqiredUpdateArgumentsException {
        //given
        Employee firstEmployee = new Employee("Jan", "Kowalski");
        listEmployeeRepository.create(firstEmployee);
        Employee secondEmployee = new Employee("Marek", "Nowak");
        listEmployeeRepository.create(secondEmployee);

       //when
        Employee updateEmployee = listEmployeeRepository
                .update("Marek", "Nowak", "Karol", null);

        assertEquals(secondEmployee, updateEmployee);
    }
}