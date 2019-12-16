package tech.lideo.company.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.service.mappers.EmployeeMapper;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {
//
//    @Mock
//    private EmployeeRepository repository;
//
//    @InjectMocks
//    private EmployeeServiceImpl service;
//
//    @Mock
//    private EmployeeMapper mapper;
//
//    @After
//    public void tearDown() {
//        Mockito.reset();
//    }
//
//    @Test
//    public void should_call_repository_find_all_method() {
//        //given
//
//        //when
//        service.findAll();
//
//        //then
//        verify(repository, times(1)).findAll();
//    }
//
//    @Test
//    public void should_call_repository_find_method() throws EmployeeNotFoundException {
//        //given
//        Long pesel = 11223344556L;
//
//        //when
//        service.find(pesel);
//
//        //then
//        verify(repository, times(1)).find(pesel);
//    }
//
//    @Test
//    public void should_call_repository_create_method() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
//        //given
//        EmployeeDTO dto = new EmployeeDTO("", "", null);
//
//        //when
//        service.create(dto);
//
//        //then
//        verify(repository, times(1)).create(mapper.mapToModel(dto));
//    }
//
//    @Test
//    public void should_call_repository_delete_method() throws EmployeeNotFoundException {
//        //given
//        Long pesel = 11223344556L;
//
//        //when
//        service.delete(pesel);
//
//        //then
//        verify(repository, times(1)).delete(pesel);
//    }
//
//    @Test
//    public void should_call_repository_update_method() throws EmployeeNotFoundException {
//        //given
//        Long pesel = 99999999999L;
//        EmployeeDTO dto = new EmployeeDTO("Karabasz", "Barabasz", 33355577798L);
//
//        //when
//        service.update(pesel, dto);
//
//        //then
//        verify(repository, times(1)).update(pesel, mapper.mapToModel(dto));
//    }
}