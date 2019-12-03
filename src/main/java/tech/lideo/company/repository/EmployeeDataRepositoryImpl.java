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

}
