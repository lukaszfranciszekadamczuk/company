package tech.lideo.company.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.mapper.MapperEmployee;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeDTO;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.EmployeeDataRepository;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.repository.exception.*;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeDataRepository employeeDataRepository;

    @InjectMocks
    private EmployeeService employeeService;

//    @Autowired
    private EmployeeDTO employeeDTO;
    private MapperEmployee mapperEmployee;

    private Employee employee;
    private EmployeeData employeeData;

    @Before
    public void setUp() throws Exception {
        employee = new Employee("Jan", "Nowak", "55050544123");
        employeeData = new EmployeeData("55050544123", new BigDecimal(100));

    }

    @After
    public void tearDown() throws Exception {
        Mockito.reset();
    }
//
//    @Test
//    public void findAll() {
//        //when
//        employeeService.findAll();
//
//        //then
//        verify(employeeRepository, times(1)).findAll();
//    }

    @Test
    public void should_return_create_employee() throws EmployeePeselException, EmployeeNotFoundException,
            EmployeeAlreadyExistsException, EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException {
        employeeRepository.create(employee);
        employeeDataRepository.create(employeeData);

        EmployeeDTO employeeDTO = new MapperEmployee().getEmployeeDTO();
        //when

        //then
        verify(employeeRepository, times(1)).create(any());
    }

//    @Test(expected = EmployeeDataNotFoundException.class)
//    public void should_return_exception_after_create_employee_with_no_maching_employee_data()
//            throws EmployeePeselException, EmployeeNotFoundException,
//            EmployeeAlreadyExistsException, EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException {
//        employeeData = new EmployeeData("55040433432", new BigDecimal(1000));
//
//        //when
//        employeeService.create(employee, employeeData);
//    }
//
//    @Test
//    public void delete() throws EmployeeNotFoundException {
//        String firstName = employee.getFirstName();
//        String lastName = employee.getLastName();
//        String pesel = employee.getPesel();
//
//        //when
//        employeeService.delete(firstName, lastName, pesel);
//
//        //then
//        verify(employeeRepository, times(1)).delete(firstName, lastName, pesel);
//    }
//
//    @Test
//    public void find() throws EmployeeNotFoundException {
//        String firstName = employee.getFirstName();
//        String lastName = employee.getLastName();
//        String pesel = employee.getPesel();
//
//        //when
//        employeeService.find(firstName, lastName, pesel);
//
//        //then
//        verify(employeeRepository, times(1)).find(firstName, lastName, pesel);
//    }
//
//    @Test
//    public void update() throws MissingReqiredUpdateArgumentsException, EmployeeNotFoundException {
//        String actualFirstName = employee.getFirstName();
//        String actualLastName = employee.getLastName();
//        String actualPesel = employee.getPesel();
//
//        String newFirstName = "Marek";
//        String newLastName = "Kowalski";
//        String newPesel = "55040444555";
//
//        //when
//        employeeService.update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
//
//        //then
//        verify(employeeRepository, times(1))
//                .update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
//    }
}