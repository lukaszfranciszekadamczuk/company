package tech.lideo.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.service.mappers.EmployeeMapper;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public List<EmployeeDTO> findAll() {

        return repository.findAll().stream()
                .map(m -> mapper.mapToDTO(m))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO find(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {

        return mapper.mapToDTO(repository.find(pesel));
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) throws EmployeeAlreadyExistsException, EmployeeNotFoundException, IllegalArgumentException {

        return mapper.mapToDTO(repository.create(mapper.mapToModel(dto)));
    }

    @Override
    public String delete(Long pesel) throws EmployeeNotFoundException, IllegalArgumentException {

        return repository.delete(pesel);
    }

    @Override
    public EmployeeDTO update(Long pesel, EmployeeDTO dto) throws EmployeeNotFoundException, IllegalArgumentException {

        return mapper.mapToDTO(repository.update(pesel, mapper.mapToModel(dto)));
    }
}
