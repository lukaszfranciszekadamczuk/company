package tech.lideo.company.repository;

import tech.lideo.company.model.Identifiable;

import java.util.List;

public interface IRepository {

    List<Identifiable> findAll();

    Identifiable find(Long id);

    Identifiable create(Identifiable identifiable);

    String delete(Long id);

    Identifiable update(Identifiable identifiable);

    void clear();

    int size();

    void validate(Long id);
}