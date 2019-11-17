package tech.lideo.company.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee("Jan", "Nowak", "55050544123");
    }

    @After
    public void tearDown() throws Exception {
        Mockito.reset();
    }

    @Test
    public void findAll() {
    }

    @Test
    public void create() throws EmployeePeselException, EmployeeNotFoundException, EmployeeAlreadyExistsException {

        //when
        Mockito.when(repository.create(employee)).thenReturn(employee);
        Employee employeeService = service.create(employee);

        //then
        verify( repository, times(1)).create(any());
    }

    @Test
    public void delete() {
    }

    @Test
    public void find() {
    }

    @Test
    public void update() {
    }
}