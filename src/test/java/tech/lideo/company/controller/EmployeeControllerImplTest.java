package tech.lideo.company.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.dto.EmployeeDTO;
import tech.lideo.company.service.EmployeeServiceImpl;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerImplTest {

    @Mock
    private EmployeeServiceImpl service;

    @InjectMocks
    private EmployeeControllerImpl controller;

    @Test
    public void should_call_service_find_all_method() {
        //given

        //when
        controller.findAll();

        //then
        verify(service, times(1)).findAll();
    }

    @Test
    public void should_call_service_find_method() throws EmployeeNotFoundException {
        //given
        Long pesel = 11223344556L;

        //when
        controller.find(pesel);

        //then
        verify(service, times(1)).find(pesel);
    }

    @Test
    public void should_call_service_create_method() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        EmployeeDTO dto = new EmployeeDTO("", "", null);

        //when
        controller.create(dto);

        //then
        verify(service, times(1)).create(dto);
    }

    @Test
    public void should_call_service_delete_method() throws EmployeeNotFoundException {
        //given
        Long pesel = 11223344556L;

        //when
        controller.delete(pesel);

        //then
        verify(service, times(1)).delete(pesel);
    }

    @Test
    public void should_call_service_update_method() throws EmployeeNotFoundException {
        //given
        Long pesel = 99999999999L;
        EmployeeDTO dto = new EmployeeDTO("Karabasz", "Barabasz", 33355577798L);

        //when
        controller.update(pesel, dto);

        //then
        verify(service, times(1)).update(pesel, dto);
    }
}