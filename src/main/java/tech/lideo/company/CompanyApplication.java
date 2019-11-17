package tech.lideo.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.lideo.company.repository.exception.EmployeeAlreadyExistsException;
import tech.lideo.company.repository.exception.EmployeeNotFoundException;
import tech.lideo.company.repository.exception.EmployeePeselException;

import java.io.IOException;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args)
            throws EmployeeNotFoundException, EmployeeAlreadyExistsException, EmployeePeselException, IOException {

        SpringApplication.run(CompanyApplication.class, args);

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
    }
}
