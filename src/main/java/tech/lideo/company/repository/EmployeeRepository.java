package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;
import tech.lideo.company.repository.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exceptions.EmployeeNotFoundException;
import tech.lideo.company.repository.exceptions.NoEmployeesException;

import java.util.List;

/**
 * A repository that stores Employees.
 * The interface provides 5 methods for working on the repository
 *
 * @author Łukasz Adamczuk
 * @author Paweł Woźny
 */

public interface EmployeeRepository {

    /**
     * Returns list of all stored Employees.
     * If the list is empty throws NoEmployeesException.
     *
     * @return <tt>List<Employee></tt> if the list contains any Employees
     * @throws NoEmployeesException if the list is empty
     */
    List<Employee> findAll() throws NoEmployeesException;

    /**
     * Returns list of searched by params Employees when given params  <tt>firstName</tt> and <tt>lastName</tt> are valid.
     * If <tt>firstName==null</tt> and <tt>lastName==null</tt> throws IllegalArgumentException.
     * If the list doesn't contain Employee with searched params throws EmployeeNotFoundException.
     *
     * @param firstName string to search Employee by first name
     * @param lastName  string to search Employee by last name
     * @return <tt>List<Employee></tt> if the list contains Employees with searched params
     * @throws IllegalArgumentException  when searched params are invalid
     * @throws EmployeeNotFoundException if the list doesn't contain Employees with searched params
     */
    List<Employee> find(String firstName, String lastName) throws EmployeeNotFoundException, IllegalArgumentException;

    /**
     * Returns added Employee when given param <tt>employee</tt> is valid.
     * If <tt>employee.getFirstName()==null</tt> and <tt>employee.getLastName()==null</tt> throws IllegalArgumentException.
     * If <tt>employee.getId()</tt> is taken by other element on the list throws EmployeeAlreadyExistsException.
     * Even if param <tt>employee</tt> is valid there is technical possibility that object cannot by added to list and
     * when such situation occurs, throws EmployeeNotFoundException.
     *
     * @param employee element to be appended to this list
     * @return <tt>Employee</tt> object added to the list
     * @throws IllegalArgumentException       when param is invalid
     * @throws EmployeeNotFoundException      if list doesn't contain added Employee
     * @throws EmployeeAlreadyExistsException when <tt>employee.getId()</tt> is taken by other element on the list
     */
    Employee create(Employee employee) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException;

    /**
     * Returns string containing deleted Employee attributes when given params <tt>firstName</tt> and <tt>lastName</tt> are valid.
     * If <tt>employee.getFirstName()==null</tt> and <tt>employee.getLastName()==null</tt> throws IllegalArgumentException.
     * If the list doesn't contain Employee to be deleted with searched params throws EmployeeNotFoundException.
     *
     * @param firstName string to search and delete Employee by first name
     * @param lastName  string to search and delete Employee by last name
     * @return <tt>String</tt> containing deleted Employee attributes
     * @throws IllegalArgumentException  when params are invalid
     * @throws EmployeeNotFoundException if list doesn't contain searched to be deleted Employee
     */
    String delete(String firstName, String lastName) throws EmployeeNotFoundException, IllegalArgumentException;

    /**
     * Returns updated Employee when given params <tt>firstName</tt>, <tt>lastName</tt>, <tt>newFrstName</tt> and <tt>newLastName</tt> are valid.
     * If <tt>firstName==null</tt> and <tt>lastName==null</tt> throws IllegalArgumentException.
     * If <tt>newFirstName==null</tt> or <tt>newLastName==null</tt> throws IllegalArgumentException.
     * If the list doesn't contain Employee to be updated with searched params throws EmployeeNotFoundException.
     *
     * @param firstName    string to search and update Employee by first name
     * @param lastName     string to search and update Employee by last name
     * @param newFirstName string to update Employees first name
     * @param newLastName  string to update Employees last name
     * @return <tt>Employee</tt> updated object
     * @throws IllegalArgumentException  when params are invalid
     * @throws EmployeeNotFoundException if list doesn't contain searched to be updated Employee
     */
    Employee update(String firstName, String lastName, String newFirstName, String newLastName) throws EmployeeNotFoundException, IllegalArgumentException;
}