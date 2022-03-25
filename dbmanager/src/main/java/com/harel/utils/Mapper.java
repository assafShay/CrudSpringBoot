package com.harel.utils;

import com.harel.model.dto.PersonDto;
import com.harel.model.entity.PersonEntity;

import java.util.UUID;

public class Mapper {
    public static PersonEntity map(PersonDto from) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(UUID.randomUUID());
        personEntity.setFullName(from.getFirstName() + " " + from.getLastName());
        personEntity.setPhone(from.getPhone());
        personEntity.setIdNum(from.getIdNum());
        personEntity.setInsertDate("2021-07-14 14:40:13");

        return personEntity;
    }

    public static PersonDto map(PersonEntity to) {
        PersonDto personDto = new PersonDto();
        personDto.setId(to.getId());
        personDto.setFirstName(String.valueOf(to.getFullName().split(" ")[0]));
        personDto.setLastName(String.valueOf(to.getFullName().split(" ")[1]));
        personDto.setPhone(to.getPhone());
        personDto.setIdNum(to.getIdNum());
        personDto.setInsertDate(to.getInsertDate());

        return personDto;
    }
}
