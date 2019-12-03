package tech.lideo.company.repository;

import org.springframework.stereotype.Repository;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Repository
public class EmployeeDataRepository implements IEmployeeDataRepository {

    private List<EmployeeData> employeeDataList = new ArrayList<>();
    private List<EmployeeData> employeeListCopy = new ArrayList<>();

    @Override
    public List<EmployeeData> findAll() {
        employeeListCopy = employeeDataList.stream()
                .collect(Collectors.toList());
        return employeeListCopy;
    }

    @Override
    public EmployeeData create(EmployeeData employeeData) throws EmployeePeselException, EmployeeDataAlreadyExistsException, EmployeeDataNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String employeeId) {
        return false;
    }

    @Override
    public EmployeeData find(String employeeId) {
        return null;
    }

    @Override
    public EmployeeData update(String actualEmployeeId, String newEmployeeId) {
        return null;
    }
}
