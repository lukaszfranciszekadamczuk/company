package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListEmployeeRepositoryTest {

    private ArrayListEmployeeRepository arrayListEmployeeRepository;

    @org.junit.Before
    public void setUp() {
        arrayListEmployeeRepository = new ArrayListEmployeeRepository();
    }

    @org.junit.After
    public void tearDown() {
    }

    @org.junit.Test
    public void should_return_true_after_create_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");

        //when
        Employee createEmployee = arrayListEmployeeRepository.create(employee);

        //then
        assertEquals(employee, createEmployee);

    }

    @org.junit.Test
    public void should_return_exception_after_add_employee_with_the_same_id() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");

        //when
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeAlreadyExistsException.class, () -> {
            arrayListEmployeeRepository.create(employee);
        });
    }

    @org.junit.Test
    public void should_return_exception_after_add_employee_without_required_argument() {
        //given
        Employee employee = new Employee(1L, null, "Kowalski");

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            arrayListEmployeeRepository.create(employee);
        });
    }

    @org.junit.Test
    public void should_return_true_after_delete_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");
        arrayListEmployeeRepository.create(employee);

        //when
        boolean isDeleted = arrayListEmployeeRepository.delete(1L);

        //then
        assertTrue(isDeleted);
    }

    @org.junit.Test
    public void should_return_exception_after_delete_employee_with_no_exists_id() {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");

        //then
        assertThrows(IllegalArgumentException.class, () ->
                arrayListEmployeeRepository.delete(null));
    }

    @org.junit.Test
    public void should_return_true_after_find_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");
        arrayListEmployeeRepository.create(employee);

        //when
        Employee employeeFind = arrayListEmployeeRepository.find(1L);

        //then
        assertEquals(employee, employeeFind);
    }

    @org.junit.Test
    public void should_return_exception_after_search_employee_with_no_exists_id() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                arrayListEmployeeRepository.find(2L));
    }

    @org.junit.Test
    public void should_return_true_after_update_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");
        Employee employeeToUpdate = new Employee(1L, "Marek", "Nowak");
        arrayListEmployeeRepository.create(employee);

        //when
        Employee updateEmployee = arrayListEmployeeRepository.update(employeeToUpdate);

        //then
        assertEquals(employeeToUpdate.getId(), updateEmployee.getId());
        assertEquals(employeeToUpdate.getFirstName(), updateEmployee.getFirstName());
        assertEquals(employeeToUpdate.getLastName(), updateEmployee.getLastName());
        assertEquals(employeeToUpdate.getCreated(), updateEmployee.getCreated());
    }

    @org.junit.Test
    public void should_return_exception_after_update_employee_with_no_exists_id() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");
        Employee employeeToUpdate = new Employee(2L, "Marek", "Nowak");
        arrayListEmployeeRepository.create(employee);

        //then
        assertThrows(EmployeeNotFoundException.class, () ->
                arrayListEmployeeRepository.update(employeeToUpdate));
    }
}