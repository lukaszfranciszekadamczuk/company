package tech.lideo.company.repository;

import tech.lideo.company.model.Employee;

public interface EmployeeRepository {

    /**
     *
     */

    Employee create(Employee employee);

    boolean delete(Long id);

    Employee find(Employee employee);

    Employee update(Employee employee);
}
