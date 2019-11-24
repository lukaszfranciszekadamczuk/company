package tech.lideo.company.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.lideo.company.service.EmployeeServiceImpl;
import tech.lideo.company.shared.exceptions.EmployeeAlreadyExistsException;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.time.LocalDate;
import java.util.UUID;

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
        UUID id = UUID.randomUUID();
        String firstName = "Pan";
        String lastName = "Pafnucy";
        Long pesel = 12345678910L;
        LocalDate created = LocalDate.now();

        //when
        controller.findAll();

        //then
        verify(service, times(1)).findAll();
    }

    @Test
    public void should_call_repository_find_method() throws EmployeeNotFoundException {
        //given
        Long pesel = 11223344556L;

        //when
        controller.find(pesel);

        //then
        verify(service, times(1)).find(pesel);
    }

    @Test
    public void should_call_repository_create_method() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
        //given
        String firstName = "";
        String lastName = "";
        Long pesel = null;

        //when
        controller.create(firstName, lastName, pesel);

        //then
        verify(service, times(1)).create(firstName, lastName, pesel);
    }

    @Test
    public void should_call_repository_delete_method() throws EmployeeNotFoundException {
        String message = "Employee ... deleted";
        //given
        Long pesel = 11223344556L;

        //when
        controller.delete(pesel);

        //then
        verify(service, times(1)).delete(pesel);
    }

    @Test
    public void should_call_repository_update_method() throws EmployeeNotFoundException {
        //given
        Long pesel = 99999999999L;
        String newFirstName = "Karabasz";
        String newLastName = "Barabasz";
        Long newPesel = 33355577798L;

        //when
        controller.update(pesel, newFirstName, newLastName, newPesel);

        //then
        verify(service, times(1)).update(pesel, newFirstName, newLastName, newPesel);
    }
}