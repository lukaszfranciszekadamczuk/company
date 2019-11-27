package tech.lideo.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tech.lideo.company.model.Employee;
import tech.lideo.company.model.EmployeeData;
import tech.lideo.company.model.EmployeeWithEmployeeData;
import tech.lideo.company.model.Salary;
import tech.lideo.company.repository.EmployeeRepository;
import tech.lideo.company.repository.exception.*;
import tech.lideo.company.service.EmployeeService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Arrays.asList;

@SpringBootApplication
@ComponentScan("tech.lideo.company")
public class CompanyApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args)
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException, IOException {

        SpringApplication.run(CompanyApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        String pesel = "88070744345";
        Employee employee = new Employee("a", "b", pesel);
        EmployeeData employeeData = new EmployeeData(pesel, asList(new Salary(LocalDate.now(), new BigDecimal(1000))));
        System.out.println("repo " + employeeRepository);
//        EmployeeWithEmployeeData e = null;
//        try {
//            e = employeeService.create(employee, employeeData);
//        } catch (EmployeeNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (EmployeeAlreadyExistsException e1) {
//            e1.printStackTrace();
//        } catch (EmployeePeselException e1) {
//            e1.printStackTrace();
//        } catch (EmployeeDataNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (EmployeeDataAlreadyExistsException e1) {
//            e1.printStackTrace();
//        }
//        System.out.println("serv " + e);
    }
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        EmployeeRepository repository = context.getBean("repository", EmployeeRepository.class);
//        EmployeeService service = context.getBean("service", EmployeeService.class);
//

//        Employee firstEmployee = new Employee("Jan", "Kowalski", "90050505555");
//        Employee secondEmployee = new Employee("Marek", "Nowak", "80060708999");
//
//        Employee employeeRepository = repository.create(firstEmployee);
//        Employee employeeService = service.create(secondEmployee);
//
//        System.out.println("Repository - First name: " + employeeRepository.getFirstName()
//                + " Last name: " + employeeRepository.getLastName()
//                + " pesel: " + employeeRepository.getPesel());
//        System.out.println("Service - First name: " + employeeService.getFirstName()
//                + " Last name: " + employeeService.getLastName()
//                + " pesel: " + employeeService.getPesel());

//ObjectMapper mapper = new ObjectMapper();
//
//        JsonBuilderFactory factory = Json.createBuilderFactory(emptyMap());
//
//        JsonArray value = factory.createArrayBuilder()
//                .add(factory.createObjectBuilder()
//                        .add("id", employeeRepository.getId().toString())
//                        .add("firstName", employeeRepository.getFirstName())
//                        .add("lastName", employeeRepository.getLastName())
//                        .add("pesel", employeeRepository.getPesel())
//                        .add("created", employeeRepository.getCreated().toString()))
//                .build();
//
//        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("employee.json"), value);


//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//
//        ow.writeValue(new File("employee.json"), employeeRepository);
//
//        String json = ow.writeValueAsString(employeeRepository);
//
//        System.out.println(json);
//    }


}
