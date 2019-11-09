package tech.lideo.company.repository;

import org.junit.jupiter.api.Assertions;
import tech.lideo.company.model.Employee;

public class ListEmployeeRepositoryTest {

    private ListEmployeeRepository listEmployeeRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        listEmployeeRepository = new ListEmployeeRepository();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void create() {
        //given
        Employee employee = new Employee(1L, "Jan", "Kowalski");

        //when
        Employee createEmployee = listEmployeeRepository.create(employee);

        //then
        Assertions.assertEquals(employee, createEmployee);

    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void find() {
    }

    @org.junit.Test
    public void update() {
    }
}