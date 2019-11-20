package tech.lideo.company.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private EmployeeRepository repository;

    @Autowired
    @InjectMocks
    private EmployeeService service;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Mockito.reset();
    }

    @Test
    public void should_return_employee_list() {
        //given
        UUID id = UUID.randomUUID();
        String firstName = "Pan";
        String lastName = "Pafnucy";
        Long pesel = 12345678910L;
        LocalDate created = LocalDate.now();

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Employee(id, firstName, lastName, pesel, created)));

        //when
        List<Employee> employees = service.findAll();

        //then
        assertEquals(1, employees.size());
        assertEquals(firstName, employees.get(0).getFirstName());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_throw_exception_after_searching_employee_with_no_existing_data() throws EmployeeNotFoundException {
        //given
        Long pesel = 11223344556L;

        Mockito.when(repository.find(pesel)).thenThrow(EmployeeNotFoundException.class);

        //when
        service.find(pesel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_after_creating_employee_with_invalid_data() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        String firstName = "";
        String lastName = "";
        Long pesel = null;

        Mockito.when(repository.create(firstName, lastName, pesel)).thenThrow(IllegalArgumentException.class);

        //when
        service.create(firstName, lastName, pesel);
    }

    @Test
    public void should_delete_employee() throws EmployeeNotFoundException {
        String message = "Employee ... deleted";
        //given
        Long pesel = 11223344556L;

        Mockito.when(repository.delete(pesel)).thenReturn(message);

        //when
        String receivedMessage = service.delete(pesel);

        //then
        assertEquals(message, receivedMessage);
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_throw_exception_after_updating_non_existing_employee() throws EmployeeNotFoundException {
        //given
        Long pesel = 99999999999L;
        String newFirstName = "Karabasz";
        String newLastName = "Barabasz";
        Long newPesel = 33355577798L;

        Mockito.when(repository.update(pesel, newFirstName, newLastName, newPesel)).thenThrow(EmployeeNotFoundException.class);

        //then
        service.update(pesel, newFirstName, newLastName, newPesel);
    }
}