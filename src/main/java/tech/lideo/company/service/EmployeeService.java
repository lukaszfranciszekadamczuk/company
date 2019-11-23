package tech.lideo.company.service;

import tech.lideo.company.model.Employee;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.List;

/**
 * A Service that is connected to Employee repository.
 * The interface provides 5 methods for working on the service
 *
 * @author Paweł Woźny
 */

public interface EmployeeService {

    /**
     * Returns list of all stored Employees.
     * If the list is empty throws NoEmployeesException.
     *
     * @return <tt>List<Employee></tt> list of Employees
     */
    List<Employee> findAll();

    /**
     * Returns Employee when given valid param <tt>pesel</tt>.
     * If <tt>pesel==null</tt> throws IllegalArgumentException.
     * If the list doesn't contain Employee with searched params throws EmployeeNotFoundException.
     *
     * @param pesel long to search Employee by unique pesel number
     * @return <tt>Employee</tt> if the list contains Employee with searched param
     * @throws IllegalArgumentException  when searched params are invalid
     * @throws EmployeeNotFoundException if the list doesn't contain Employees with searched params
     */
    Employee find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException;

    /**
     * Returns added Employee when given param <tt>employee</tt> is valid.
     * If <tt>employee.getFirstName()==null</tt> and <tt>employee.getLastName()==null</tt> throws IllegalArgumentException.
     * If <tt>employee.getId()</tt> is taken by other element on the list throws EmployeeAlreadyExistsException.
     * Even if param <tt>employee</tt> is valid there is technical possibility that object cannot by added to list and
     * when such situation occurs, throws EmployeeNotFoundException.
     *
     * @param firstName string to create Employee with first name
     * @param lastName  string to create Employee with last name
     * @param pesel     number to create Employee with pesel
     * @return <tt>Employee</tt> object added to the list
     * @throws IllegalArgumentException       when param is invalid
     * @throws EmployeeNotFoundException      if list doesn't contain added Employee
     * @throws EmployeeAlreadyExistsException when <tt>employee.getPesel()</tt> is taken by other element on the list
     */
    Employee create(String firstName, String lastName, Long pesel) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException;

    /**
     * Returns string containing deleted Employee attributes when given params <tt>firstName</tt> and <tt>lastName</tt> are valid.
     * If <tt>employee.getFirstName()==null</tt> and <tt>employee.getLastName()==null</tt> throws IllegalArgumentException.
     * If the list doesn't contain Employee to be deleted with searched params throws EmployeeNotFoundException.
     *
     * @param pesel to search and delete Employee pesel
     * @return <tt>String</tt> containing deleted Employee attributes
     * @throws IllegalArgumentException  when param is invalid
     * @throws EmployeeNotFoundException if list doesn't contain searched Employee to be deleted
     */
    String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException;

    /**
     * Returns updated Employee when given params <tt>firstName</tt>, <tt>lastName</tt>, <tt>newFrstName</tt> and <tt>newLastName</tt> are valid.
     * If <tt>firstName==null</tt> and <tt>lastName==null</tt> throws IllegalArgumentException.
     * If <tt>newFirstName==null</tt> or <tt>newLastName==null</tt> throws IllegalArgumentException.
     * If the list doesn't contain Employee to be updated with searched params throws EmployeeNotFoundException.
     *
     * @param pesel        number to search and update Employee by pesel
     * @param newFirstName string to update Employees first name
     * @param newLastName  string to update Employees last name
     * @param newPesel     number to update Employees pesel
     * @return <tt>Employee</tt> updated object
     * @throws IllegalArgumentException  when params are invalid
     * @throws EmployeeNotFoundException if list doesn't contain searched to be updated Employee
     */
    Employee update(Long pesel, String newFirstName, String newLastName, Long newPesel) throws EmployeeNotFoundException, IllegalArgumentException;
}