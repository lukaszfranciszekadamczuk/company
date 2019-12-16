package tech.lideo.company.repository;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.shared.exceptions.EmployeeDataAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeDataNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class EmployeeDataRepositoryImpl implements EmployeeDataRepository {
//
//    private List<EmployeeData> employeesData = new ArrayList<>();
//    private Gson gson = new Gson();
//
//    {
//        employeesData.add(new EmployeeData(1L,12345678919L, LocalDate.now(), new BigDecimal(666)));
//    }
//
//    @Override
//    public List<EmployeeData> findAll() {
//        List<EmployeeData> copiedList = new ArrayList<>();
//
//        for (EmployeeData e : employeesData) {
//            String ed = gson.toJson(e);
//            copiedList.add(gson.fromJson(ed, EmployeeData.class));
//        }
//        return copiedList;
//    }
//
//    @Override
//    public EmployeeData find(Long pesel, LocalDate date) throws EmployeeDataNotFoundException {
//        validate(pesel);
//
//        EmployeeData data = employeesData.stream()
//                .filter(e -> e.getPesel().equals(pesel))
//                .filter(e -> e.getDate().equals(date))
//                .findAny()
//                .orElseThrow(EmployeeDataNotFoundException::new);
//
//        String ed = gson.toJson(data);
//
//        return gson.fromJson(ed, EmployeeData.class);
//    }
//
//    @Override
//    public EmployeeData create(EmployeeData model) throws EmployeeDataAlreadyExistsException, EmployeeDataNotFoundException {
//        validate(model);
//        validate(model.getPesel());
//
//        boolean employeeDataExists = employeesData.stream()
//                .anyMatch(e -> e.getPesel().equals(model.getPesel()) && e.getDate().equals(model.getDate()));
//
//        if (employeeDataExists) {
//            throw new EmployeeDataAlreadyExistsException();
//        }
//
//        employeesData.add(model);
//
//        EmployeeData data = employeesData.stream()
//                .filter(e -> e.getPesel().equals(model.getPesel()))
//                .filter(e -> e.getDate().equals(model.getDate()))
//                .findFirst()
//                .orElseThrow(EmployeeDataNotFoundException::new);
//
//        String ed = gson.toJson(data);
//
//        return gson.fromJson(ed, EmployeeData.class);
//    }
//
//    @Override
//    public String delete(Long pesel, LocalDate date) throws EmployeeDataNotFoundException {
//        validate(pesel);
//
//        EmployeeData employeeDataToDelete = employeesData.stream()
//                .filter(e -> e.getPesel().equals(pesel))
//                .filter(e -> e.getDate().equals(date))
//                .findAny()
//                .orElseThrow(EmployeeDataNotFoundException::new);
//
//        employeesData.removeIf(e -> e.getPesel().equals(pesel) && e.getDate().equals(date));
//
//        return "Deleted employee data: " + employeeDataToDelete;
//    }
//
//    @Override
//    public EmployeeData update(Long pesel, LocalDate date, EmployeeData model) throws EmployeeDataNotFoundException {
//        validate(pesel);
//        validate(model);
//
//        EmployeeData dataToUpdate = employeesData.stream()
//                .filter(e -> e.getPesel().equals(pesel))
//                .filter(e -> e.getDate().equals(date))
//                .findFirst()
//                .orElseThrow(EmployeeDataNotFoundException::new);
//
//        boolean isEmployeeDataDeleted = employeesData.removeIf(e -> e.getPesel().equals(pesel) && e.getDate().equals(date));
//
//        if (!isEmployeeDataDeleted) {
//            throw new EmployeeDataNotFoundException();
//        }
//
//        EmployeeData updatedData = new EmployeeData(
//                dataToUpdate.getId(),
//                returnPesel(pesel, model.getPesel()),
//                returnDate(date, model.getDate()),
//                model.getSalary()
//        );
//
//        employeesData.add(updatedData);
//
//        EmployeeData data = employeesData.stream()
//                .filter(e -> e.getPesel().equals(model.getPesel()))
//                .filter(e -> e.getDate().equals(model.getDate()))
//                .findFirst()
//                .orElseThrow(EmployeeDataNotFoundException::new);
//
//        String ed = gson.toJson(data);
//
//        return gson.fromJson(ed, EmployeeData.class);
//    }
//
//    @Override
//    public void clear() {
//        employeesData.clear();
//
//    }
//
//    @Override
//    public int size() {
//        return employeesData.size();
//    }
//
//    @Override
//    public void validate(EmployeeData model) {
//        if (isNull(model.getSalary())) {
//            throw new IllegalArgumentException();
//        }
//    }
//
//    @Override
//    public void validate(Long pesel) throws IllegalArgumentException {
//        if (isNull(pesel)) {
//            throw new IllegalArgumentException();
//        }
//
//        if (11 != pesel.toString().length()) {
//            throw new IllegalArgumentException();
//        }
//
//        for (int i = 0; i < pesel.toString().length(); i++) {
//            if (!Character.isDigit(pesel.toString().charAt(i))) {
//                throw new IllegalArgumentException();
//            }
//        }
//
//        if (pesel.toString().charAt(0) == 0) {
//            throw new IllegalArgumentException();
//        }
//
//        if (pesel.compareTo(0L) <= 0) {
//            throw new IllegalArgumentException();
//        }
//    }
//
//    private Long returnPesel(Long pesel, Long newPesel) {
//        try {
//            validate(newPesel);
//            return newPesel;
//        } catch (IllegalArgumentException ex) {
//            return pesel;
//        }
//    }
//
//    private LocalDate returnDate(LocalDate date, LocalDate newDate) {
//        if (isNull(newDate)) {
//            return date;
//        } else {
//            return newDate;
//        }
//    }
//
//    private BigDecimal returnSalary(BigDecimal salary, BigDecimal newSalary) {
//        if (isNull(newSalary)) {
//            return salary;
//        } else {
//            return newSalary;
//        }
//    }
}
