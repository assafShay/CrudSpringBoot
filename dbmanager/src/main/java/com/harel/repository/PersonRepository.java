package com.harel.repository;

import com.harel.model.entity.PersonEntity;
import java.util.List;
import java.util.Optional;


public interface PersonRepository {

    Integer insertPerson(PersonEntity personEntity);

    List<PersonEntity> selectAllPeople();

    Optional<PersonEntity> selectPersonById(String idNum);

    boolean deletePersonById(String idNum);

    Integer updatePersonById(String idNum, PersonEntity personEntity);
}
