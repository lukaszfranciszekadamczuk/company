//package tech.lideo.company.controller;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import tech.lideo.company.model.Employee;
//import tech.lideo.company.model.EmployeeDTO;
//import tech.lideo.company.model.EmployeeData;
//import tech.lideo.company.repository.exception.*;
//import tech.lideo.company.service.EmployeeService;
//
//import java.math.BigDecimal;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class EmployeeControllerTest {
//
//    @Mock
//    private EmployeeService employeeService;
//
//    @InjectMocks
//    private EmployeeController employeeController;
//
//    private Employee employee;
//    private EmployeeData employeeData;
//    private EmployeeDTO dto;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        employee = new Employee("Jan", "Nowak", "55050544123");
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        Mockito.reset();
//    }
//
//    @Test
//    public void findAll() {
//        //when
//        employeeController.findAll();
//
//        //then
//        verify(employeeService, times(1)).findAll();
//    }
//
//    @Test
//    public void create() throws EmployeePeselException, EmployeeNotFoundException,
//            EmployeeAlreadyExistsException, EmployeeDataNotFoundException, EmployeeDataAlreadyExistsException {
//        employeeData = new EmployeeData(employee.getPesel(), new BigDecimal(1000));
//
//
//        //when
//        employeeController.create(dto);
//
//        //then
//        verify(employeeService, times(1)).create(any(), any());
//    }
//
//    @Test
//    public void delete() throws EmployeeNotFoundException {
//        String firstName = employee.getFirstName();
//        String lastName = "Nowak";
//        String pesel = "55050544123";
//
//        //when
//        employeeController.delete(firstName, lastName, pesel);
//
//        //then
//        verify(employeeService, times(1)).delete(firstName, lastName, pesel);
//    }
//
//    @Test
//    public void find() throws EmployeeNotFoundException {
//        String firstName = "Jan";
//        String lastName = "Nowak";
//        String pesel = "55050544123";
//
//        //when
//        employeeController.find(firstName, lastName, pesel);
//
//        //then
//        verify(employeeService, times(1)).find(firstName, lastName, pesel);
//    }
//
//    @Test
//    public void update() throws MissingReqiredUpdateArgumentsException, EmployeeNotFoundException {
//        String actualFirstName = "Jan";
//        String actualLastName = "Nowak";
//        String actualPesel = "55050544123";
//
//        String newFirstName = "Marek";
//        String newLastName = "Kowalski";
//        String newPesel = "55040444555";
//
//        //when
//        employeeController.update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
//
//        //then
//        verify(employeeService, times(1))
//                .update(actualFirstName, actualLastName, actualPesel, newFirstName, newLastName, newPesel);
//    }
//}