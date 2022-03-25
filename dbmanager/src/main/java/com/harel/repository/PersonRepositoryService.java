package com.harel.repository;

import com.harel.model.entity.PersonEntity;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("FakeDb")
public class PersonRepositoryService implements PersonRepository {

    private static List<PersonEntity> DB = new ArrayList<>();

    @Override
    public Integer insertPerson(PersonEntity personEntity) {
    if (personEntity == null || personEntity.getIdNum() == null) {
        return 1;
    }

        for (PersonEntity p : DB) {
            if (p == null || p.getIdNum() == null || p.getIdNum().equals(personEntity.getIdNum())) {
                return 2;
            }
        }

        DB.add(personEntity);
        return 0;
    }

    @Override
    public List<PersonEntity> selectAllPeople() {
        return new ArrayList<>(DB);
    }

    @Override
    public Optional<PersonEntity> selectPersonById(String idNum) {
        for (PersonEntity p : DB) {
            if (p.getIdNum().equals(idNum)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deletePersonById(String id) {
        Optional<PersonEntity> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return false;
        }

        DB.remove(personMaybe.get());
        return true;
    }

    @Override
    public Integer updatePersonById(String id, PersonEntity personEntity) {
        Optional<PersonEntity> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 1;
        }

        int indexPersonToDelete = DB.indexOf(personEntity);
        if (indexPersonToDelete >= 0) {
            DB.set(indexPersonToDelete, personEntity);
            return 0;
        }

        return 2;
    }
}
