package com.harel.repository;

import com.harel.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositorySqlServer extends JpaRepository<PersonEntity,String>  {
}
