package tech.lideo.company.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;
import tech.lideo.company.repository.exception.MissingReqiredUpdateArgumentsException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    private Employee employeeOne;
    private Employee employeeTwo;
    private Employee employeeWithoutFirstName;
    private Employee employeeWithout11CharactersPesel;

    @Before
    public void setUp() {
        //given
        employeeOne = new Employee("Jan", "Kowalski", "90050505555");
        employeeTwo = new Employee("Marek", "Nowak", "80060708999");
        employeeWithout11CharactersPesel = new Employee("Kazimierz", "Marczak", "123");
        employeeWithoutFirstName = new Employee(null, "Kowalski", "7001020222");
    }

    @After
    public void tearDown() {
        repository.findAll().clear();
    }

    @Test
    public void should_return_employee_list()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);
        int listSize = repository.findAll().size();

        //then
        assertEquals(2, listSize);
        assertEquals(employeeOne.getId(), repository.findAll().get(0).getId());
        assertEquals(employeeTwo.getId(), repository.findAll().get(1).getId());
    }

    @Test
    public void should_create_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        Employee createEmployee = repository.create(employeeOne);

        //then
        assertEquals(employeeOne, createEmployee);
    }

    @Test(expected = EmployeeAlreadyExistsException.class)
    public void should_return_exception_after_create_employee_with_the_same_pesel()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeOne);
    }

    @Test(expected = EmployeePeselException.class)
    public void should_return_exception_after_create_employee_with_no_11_characters_pesel()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeWithout11CharactersPesel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_exception_after_create_employee_with_no_reqired_data()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeWithoutFirstName);
    }

    @Test
    public void should_delete_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        boolean isEmployeeDelete = repository.delete("Marek", "Nowak", "80060708999");

        //then
        assertEquals(true, isEmployeeDelete);
        assertEquals(1, repository.findAll().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_exception_after_delete_employee_with_no_reqired_data()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);

        repository.delete(null, "Kowaski", "90050505555");
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_return_exception_after_delete_no_exist_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        repository.delete("Rafał", "Majka", "90050505555");
    }

    @Test
    public void should_find_employee() throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        Employee searchingEmployee = repository.find("Marek", "Nowak", "80060708999");

        //then
        assertEquals(employeeTwo, searchingEmployee);
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_return_exception_after_search_no_exist_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        repository.find("Paweł", "Majak", "80060708999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_exception_after_search_by_no_reqired_data()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        repository.find(null, "Nowak", "80060708999");
    }

    @Test
    public void should_update_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException,
            MissingReqiredUpdateArgumentsException, EmployeePeselException {
        //given
        String newFirstName = "Tadeusz";
        String newLastName = "Nalepa";
        String newPesel = "82020202999";

        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        Employee updateEmployee = repository
                .update("Marek", "Nowak", "80060708999",
                        newFirstName, newLastName, newPesel);

        //then
        assertEquals(newFirstName, updateEmployee.getFirstName());
        assertEquals(newLastName, updateEmployee.getLastName());
        assertEquals(newPesel, updateEmployee.getPesel());
    }

    @Test
    public void should_update_employee_with_at_least_one_reqired_argument()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException,
            MissingReqiredUpdateArgumentsException, EmployeePeselException {
        //given
        String newFirstName = "Karol";

        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        Employee updateEmployee = repository
                .update("Marek", "Nowak", "80060708999",
                        newFirstName, null, null);

        //then
        assertEquals(newFirstName, updateEmployee.getFirstName());
        assertEquals(employeeTwo.getLastName(), updateEmployee.getLastName());
        assertEquals(employeeTwo.getPesel(), updateEmployee.getPesel());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void should_return_exception_after_update_no_exist_employee()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException,
            MissingReqiredUpdateArgumentsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        repository
                .update("Roman", "Kostrzewa", "80060708999",
                        "Tadeusz", "Nalepa", "6606070111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_exception_after_update_employee_without_requred_argument()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException,
            MissingReqiredUpdateArgumentsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        repository
                .update(null, "Nowak", "80060708999",
                        "Tadeusz", "Nalepa", "55050505123");
    }

    @Test(expected = MissingReqiredUpdateArgumentsException.class)
    public void should_return_exception_after_update_employee_with_missing_required_argument()
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException,
            MissingReqiredUpdateArgumentsException, EmployeePeselException {
        //when
        repository.create(employeeOne);
        repository.create(employeeTwo);

        repository
                .update("Marek", "Nowak", "80060708999",
                        null, null, null);
    }
}