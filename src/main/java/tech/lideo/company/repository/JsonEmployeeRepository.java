package tech.lideo.company.repository;

import org.springframework.stereotype.Repository;

@Repository
public class JsonEmployeeRepository {

//    private ObjectMapper mapper = new ObjectMapper();
//    private JsonArray array = Json.createArrayBuilder().build();
//    private String path = "persistence/employee-repository.json";
//
//    public Employee create(Employee employee) throws IOException, EmployeeNotFoundException {
//
//        if (isNull(employee.getId()) || isNull(employee.getFirstName()) || isNull(employee.getLastName())) {
//            throw new IllegalArgumentException();
//        }
//
//        JsonBuilderFactory factory = Json.createBuilderFactory(emptyMap());
//
//        JsonArray value = factory.createArrayBuilder()
//                .add(factory.createObjectBuilder()
//                        .add("id", employee.getId())
//                        .add("firstName", employee.getFirstName())
//                        .add("lastName", employee.getLastName())
//                        .add("created", employee.getCreated().toString()))
//                .build();
//
//        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), value);
//        List<Employee> employeeList = (List<Employee>) mapper.readValue(path, Employee.class);
//
//        return employeeList.stream()
//                .findFirst()
//                .filter(e -> e.getId().equals(employee.getId()))
//                .orElseThrow(EmployeeNotFoundException::new);
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        return false;
//    }
//
//    @Override
//    public Employee find(Long id) {
//        return null;
//    }
//
//    @Override
//    public Employee update(Employee employee) {
//        return null;
//    }
}
