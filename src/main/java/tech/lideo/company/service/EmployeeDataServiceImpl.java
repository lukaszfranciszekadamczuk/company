package tech.lideo.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import tech.lideo.company.dto.EmployeeDataDTO;
import tech.lideo.company.repository.EmployeeDataRepository;
import tech.lideo.company.service.mappers.EmployeeDataMapper;
import tech.lideo.company.shared.exceptions.EmployeeDataAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeDataNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDataServiceImpl implements EmployeeDataService {

    @Autowired
    private EmployeeDataRepository repository;

    @Autowired
    private EmployeeDataMapper mapper;

    @Override
    public List<EmployeeDataDTO> findAll() {

        return repository.findAll().stream()
                .map(m -> mapper.mapToDTO(m))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDataDTO find(Long pesel, LocalDate date) throws EmployeeDataNotFoundException {

        return mapper.mapToDTO(repository.find(pesel, date));
    }

    @Override
    public EmployeeDataDTO create(EmployeeDataDTO dto) throws EmployeeDataAlreadyExistsException, EmployeeDataNotFoundException {

        return mapper.mapToDTO(repository.create(mapper.mapToModel(dto)));
    }

    @Override
    public String delete(Long pesel, LocalDate date) throws EmployeeDataNotFoundException {

        return repository.delete(pesel, date);
    }

    @Override
    public EmployeeDataDTO update(Long pesel, LocalDate date, EmployeeDataDTO dto) throws EmployeeDataNotFoundException {

        return mapper.mapToDTO(repository.update(pesel, date, mapper.mapToModel(dto)));
    }
}
