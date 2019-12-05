package tech.lideo.company.repository;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.repository.exception.EmployeAlreadyHaveSalaryForThisDayException;
import tech.lideo.company.repository.exception.EmployeeDataAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeDataNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class EmployeeDataRepository implements IEmployeeDataRepository {

    private List<EmployeeData> employeeDataList = new ArrayList<>();
    private List<EmployeeData> employeeDataCopyList = new ArrayList<>();
    private Gson gson = new Gson();


    @Override
    public List<EmployeeData> findAll() {
        for (EmployeeData ed : employeeDataList) {
            String employeeDataToJson = gson.toJson(ed);
            employeeDataCopyList.add(gson.fromJson(employeeDataToJson, EmployeeData.class));
        }
        return employeeDataCopyList;
    }

    @Override
    public EmployeeData create(EmployeeData employeeData)
            throws EmployeePeselException, EmployeeDataNotFoundException,
            EmployeAlreadyHaveSalaryForThisDayException {
        validate(employeeData);
        validate(employeeData.getEmployeeId());

        boolean isEmployeeHaveSalaryInThisDay = employeeDataList.stream()
                .anyMatch(e -> e.getEmployeeId().equals(employeeData.getEmployeeId())
                        && e.getDate().equals(employeeData.getDate()));

        if (isEmployeeHaveSalaryInThisDay)
            throw new EmployeAlreadyHaveSalaryForThisDayException();

        employeeDataList.add(employeeData);

        return employeeDataList.stream()
                .filter(e -> e.getEmployeeId().equals(employeeData.getEmployeeId()))
                .filter(e -> e.getDate().equals(employeeData.getDate()))
                .filter(e -> e.getSalary().equals(employeeData.getSalary()))
                .findFirst()
                .orElseThrow(EmployeeDataNotFoundException::new);
    }

    @Override
    public boolean delete(String pesel, LocalDate date) {
        return false;
    }

    @Override
    public EmployeeData find(String pesel, LocalDate date) {
        return null;
    }

    @Override
    public EmployeeData update(String actualPesel, LocalDate actualDate, String newPesel, LocalDate newDate) {
        return null;
    }

    @Override
    public void clear() {
        employeeDataCopyList.clear();

    }

    @Override
    public int size() {
        return employeeDataCopyList.size();
    }

    @Override
    public void validate(EmployeeData employeeData) {
        if (isNull(employeeData.getEmployeeId()) || isNull(employeeData.getDate()) || isNull(employeeData.getSalary()))
            throw new IllegalArgumentException(
                    "All employee data are required");
    }

    @Override
    public void validate(String pesel) throws EmployeePeselException {
        if (pesel.length() != 11)
            throw new EmployeePeselException(
                    "Employee pesel should have 11 characters"
            );
    }
}
