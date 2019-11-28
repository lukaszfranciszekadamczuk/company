package tech.lideo.company.repository;

import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeDataRepositoryImpl implements EmployeeDataRepository {

    private List<EmployeeData> employeesData = new ArrayList<>();

    @Override
    public List<EmployeeData> findAll() {
        return null;
    }

    @Override
    public EmployeeData find(LocalDate date, Long pesel) {
        return null;
    }

    @Override
    public List<EmployeeData> find(Long pesel) {
        return null;
    }

    @Override
    public EmployeeData create(UUID user_id, LocalDate startDate, LocalDate endDate, BigDecimal salary, Long pesel) {
        return null;
    }

    @Override
    public String delete(LocalDate startDate, LocalDate endDate, Long pesel) {
        return null;
    }

    @Override
    public String delete(Long pesel) {
        return null;
    }

    @Override
    public Employee update(LocalDate date, Long pesel, UUID newUser_id, LocalDate newDate, BigDecimal newSalary, Long newPesel) {
        return null;
    }

    @Override
    public int size() {
        return employeesData.size();
    }
}
