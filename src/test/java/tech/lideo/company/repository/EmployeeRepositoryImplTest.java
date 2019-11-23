package tech.lideo.company.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.model.Employee;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryImplTest {

    @Autowired
    private EmployeeRepository repository;

    @Before
    public void setUp() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        repository.create("Jan", "Kowalski", 12345678910L);
        repository.create("Marek", "Nowak", 10987654321L);
    }

    @After
    public void tearDown() {
        repository.clear();
    }

    @Test
    public void should_return_employee_list() {
        //given

        //when
        List<Employee> list = repository.findAll();

        //then
        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void should_create_employee_when_given_data_is_valid() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        String firstName = "Pan";
        String lastName = "Tadeusz";
        Long pesel = 82113006812L;

        //when
        Employee createdEmployee = repository.create(firstName, lastName, pesel);

        //then
        assertEquals(firstName, createdEmployee.getFirstName());
        assertEquals(lastName, createdEmployee.getLastName());
        assertEquals(pesel, createdEmployee.getPesel());
    }

    @Test(expected = EmployeeAlreadyExistsException.class)
    public void should_throw_exception_after_adding_employee_with_taken_pesel() throws
            EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        String firstName = "Ali";
        String lastName = "Baba";
        Long pesel = 12345678910L;

        //when
        repository.create(firstName, lastName, pesel);

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_after_creating_employee_with_invalid_data() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        String firstName = "";
        String lastName = "";
        Long pesel = null;

        //when
        repository.create(firstName, lastName, pesel);

        //then
    }

    @Test
    public void should_delete_employee() throws EmployeeNotFoundException {
        //given
        Long pesel = 12345678910L;

        //when
        repository.delete(pesel);

        //then
        assertEquals(1, repository.findAll().size());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_throw_exception_after_deleting_employee_with_no_existing_data() throws
            EmployeeNotFoundException {
        //given
        Long pesel = 99999999999L;

        //when
        repository.delete(pesel);

        //then
    }

    @Test
    public void should_find_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Long pesel = 12345678910L;

        //when
        Employee foundEmployee = repository.find(pesel);

        //then
        assertEquals(pesel, foundEmployee.getPesel());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_throw_exception_after_searching_employee_with_no_existing_data() throws
            EmployeeNotFoundException {
        //given
        Long pesel = 99999999999L;

        //when
        repository.find(pesel);

        //then
    }

    @Test
    public void should_update_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        Long pesel = 12345678910L;
        String newFirstName = "Karabasz";
        String newLastName = null;
        Long newPesel = 33355577798L;
        Employee savedEmployee = repository.find(pesel);

        //when
        Employee updatedEmployee = repository
                .update(pesel, newFirstName, newLastName, newPesel);

        //then
        assertEquals(savedEmployee.getId(), updatedEmployee.getId());
        assertEquals(newFirstName, updatedEmployee.getFirstName());
        assertEquals(savedEmployee.getLastName(), updatedEmployee.getLastName());
        assertEquals(newPesel, updatedEmployee.getPesel());

    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_throw_exception_after_updating_non_existing_employee() throws
            EmployeeNotFoundException {
        //given
        Long pesel = 99999999999L;
        String newFirstName = "Karabasz";
        String newLastName = "Barabasz";
        Long newPesel = 33355577798L;

        //when
        repository.update(pesel, newFirstName, newLastName, newPesel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_after_updating_employee_with_invalid_data() throws
            EmployeeNotFoundException {
        //given
        Long pesel = 12345678910L;
        String newFirstName = null;
        String newLastName = null;
        Long newPesel = null;

        //when
        repository.update(pesel, newFirstName, newLastName, newPesel);

        //then
    }
}