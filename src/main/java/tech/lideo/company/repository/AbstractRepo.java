//package tech.lideo.company.repository;
//
//import tech.lideo.company.model.Employee;
//import tech.lideo.company.model.Identifable;
//import tech.lideo.company.repository.exception.EmployeeNotFoundException;
//import tech.lideo.company.repository.exception.MissingReqiredUpdateArgumentsException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public  abstract class AbstractRepo<Entity extends Identifable> implements IEmployeeRepository<Entity> {
//
//    private List<Entity> entities = new ArrayList<>();
//
//    @Override
//    public List<Entity> findAll() {
//
//        return null;
//    }
//
//    @Override
//    public int employeeListSize() {
//        return 0;
//    }
//
//    abstract void validate();
//
//    @Override
//    public Entity create(Entity entity) {
//
//        validate();
//
//        entity.setId(UUID.randomUUID());
//        entities.add(entity);
//
//        return entity;
//    }
//
//    @Override
//    public boolean delete(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
//        return false;
//    }
//
//    @Override
//    public Employee find(String firstName, String lastName, String pesel) throws EmployeeNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Employee update(String actualFirstName, String actualLastName, String actualPesel, String newFirstName, String newLastName, String newPesel) throws EmployeeNotFoundException, MissingReqiredUpdateArgumentsException {
//        return null;
//    }
//}
