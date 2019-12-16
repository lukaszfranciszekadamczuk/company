package tech.lideo.company.repository;

import tech.lideo.company.model.Identifiable;
import tech.lideo.company.shared.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository implements IRepository {

    private List<Identifiable> identifiable = new ArrayList<>();

    abstract Class getClazz();

    @Override
    public List<Identifiable> findAll() {
        return identifiable;
    }

    @Override
    public Identifiable find(Long pesel) {
        validate(pesel);

        return identifiable.stream()
                .filter(e -> e.getPesel().equals(pesel))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public String delete(Long id) {
        validate(id);

        Identifiable entity = identifiable.stream()
                .filter(e -> e.getPesel().equals(id))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);

        identifiable.removeIf(e -> e.getPesel().equals(id));

        return "Deleted entity: " + entity;
    }

    @Override
    public Identifiable create(Identifiable model) {
        validate(model.getPesel());
        identifiable.add(model);

        return find(model.getPesel());
    }

    @Override
    public void clear() {
        identifiable.clear();
    }

    @Override
    public int size() {
        return identifiable.size();
    }
}