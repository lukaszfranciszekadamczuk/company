package tech.lideo.company.repository;

import tech.lideo.company.model.Identifiable2;

public interface EmployeeRepository extends IRepository {

    void validate(Identifiable2 model);
}