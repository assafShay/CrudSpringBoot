package com.harel.repository;

import com.harel.model.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("RepositorySql")
public class PersonRepositorySqlServerService implements PersonRepository {

    private PersonRepositorySqlServer repository;

    @Autowired
    public PersonRepositorySqlServerService(PersonRepositorySqlServer repository) {
        this.repository = repository;
    }

    @Override
    public Integer insertPerson(PersonEntity personEntity) {
        if (personEntity == null || personEntity.getIdNum() == null) {
            return 1;
        }

        for (PersonEntity p : repository.findAll()) {
            if (p == null || p.getIdNum() == null || p.getIdNum().equals(personEntity.getIdNum())) {
                return 2;
            }
        }
        repository.save(personEntity);
        return 0;
    }

    @Override
    public List<PersonEntity> selectAllPeople() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Optional<PersonEntity> selectPersonById(String idNum) {
        for (PersonEntity p : repository.findAll()) {
            if (p.getIdNum().equals(idNum)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deletePersonById(String idNum) {
        Optional<PersonEntity> personMaybe = selectPersonById(idNum);
        if (personMaybe.isEmpty()) {
            return false;
        }
        repository.delete(personMaybe.get());
        return true;
    }

    @Override
    public Integer updatePersonById(String idNum, PersonEntity personEntity) {
        Optional<PersonEntity> personMaybe = selectPersonById(idNum);
        if (personMaybe.isEmpty()) {
            return 1;
        }

        PersonEntity pe = repository.save(personEntity);

        if (pe.equalsByFields(personEntity)) {
            return 0;
        }

        return 2;
    }
}
