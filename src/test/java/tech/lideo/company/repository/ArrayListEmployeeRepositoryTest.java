package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Employee employee = new Employee("Jan", "Kowalski");

        //when
        String createEmployee = arrayListEmployeeRepository.create(employee);

        //then
//        assertEquals({"id=" + employee.getId() + ", firstName=" + employee.getFirstName() + ", lastName=" + employee.getLastName() + ", created =" + employee.getCreated()}, createEmployee);


    }

        @org.junit.Test
        public void should_return_exception_after_add_employee_with_the_same_id () throws
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

        @org.junit.Test
        public void should_return_exception_after_add_employee_without_required_argument () {
            //given
            Employee employee = new Employee(null, "Kowalski");

            //then
            assertThrows(IllegalArgumentException.class, () -> {
                arrayListEmployeeRepository.create(employee);
            });
        }

        @org.junit.Test
        public void should_delete_employee () throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
            //given
            Employee employee = new Employee("Jan", "Kowalski");
            String employeeString = "Employee{" +
                    "id=" + employee.getId() +
                    ", firstName='" + "Jan" + '\'' +
                    ", lastName='" + "Kowalski" + '\'' +
                    ", created=" + employee.getCreated() +
                    '}';
            arrayListEmployeeRepository.create(employee);

            //when
            String isDeleted = arrayListEmployeeRepository.delete("Jan", "Kowalski");

            //then
//            assertEquals(employeeString, isDeleted);
        }

        @org.junit.Test
        public void should_return_exception_after_delete_employee_with_no_exists_data () {
            //given
            Employee employee = new Employee("Jan", "Kowalski");

            //then
            assertThrows(EmployeeNotFoundException.class, () ->
                    arrayListEmployeeRepository.delete("Tadeusz", "Nowak"));
        }

        @org.junit.Test
        public void should_find_employee () throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
            //given
            Employee employee = new Employee("Henryk", "Sienkiewicz");
            arrayListEmployeeRepository.create(employee);

            //when
            List<Employee> foundEmployee = arrayListEmployeeRepository.find("Henryk", "Sienkiewicz");

            //then
            assertEquals(employee, foundEmployee.get(0));
        }

        @org.junit.Test
        public void should_return_exception_after_search_employee_with_no_exists_data () throws
        EmployeeNotFoundException, EmployeeAlreadyExistsException {
            //given
            Employee employee = new Employee("Kaczor", "Donald");
            arrayListEmployeeRepository.create(employee);

            //then
            assertThrows(EmployeeNotFoundException.class, () ->
                    arrayListEmployeeRepository.find("Papa", "Smerf"));
        }

        @org.junit.Test
        public void should_return_true_after_update_employee () throws
        EmployeeNotFoundException, EmployeeAlreadyExistsException {
//            //given
//            Employee employee = new Employee("Jerry", "Łopata");
//            String newLastName = "Shovel";
//            arrayListEmployeeRepository.create(employee);
//            Employee updatedEmployee = new Employee();
//            updatedEmployee.setId(employee.getId());
//            updatedEmployee.setFirstName(employee.getFirstName());
//            updatedEmployee.setLastName(newLastName);
//            updatedEmployee.setCreated(employee.getCreated());
//
//            //when
//            String updateEmployee = arrayListEmployeeRepository.update("Jerry", "Łopata", null, newLastName);
//
//            then
//            assertEquals("Updated employee: " + employee + " to: " + updatedEmployee, updateEmployee);
        }

        @org.junit.Test
        public void should_return_exception_after_update_employee_with_no_exists_data () throws
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
    }