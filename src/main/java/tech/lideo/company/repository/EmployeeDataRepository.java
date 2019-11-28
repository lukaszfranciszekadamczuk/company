package tech.lideo.company.repository;

import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EmployeeDataRepository {

    List<EmployeeData> findAll();

    EmployeeData find(LocalDate date, Long pesel);

    List<EmployeeData> find(Long pesel);

    EmployeeData create(UUID user_id, LocalDate startDate, LocalDate endDate, BigDecimal salary, Long pesel);

    String delete(LocalDate startDate, LocalDate endDate, Long pesel);

    String delete(Long pesel);

    Employee update(LocalDate date, Long pesel, UUID newUser_id, LocalDate newDate, BigDecimal newSalary, Long newPesel);

    int size();
}