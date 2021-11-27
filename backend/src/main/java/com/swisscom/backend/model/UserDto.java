package com.swisscom.backend.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @CsvBindByName(column = "first_name")
    private String firstName;

    @CsvBindByName(column = "last_name")
    private String lastName;

    @CsvBindByName(column = "department")
    private String department;

    @CsvBindByName(column = "birthdate")
    private String birthDate;

    @CsvBindByName(column = "costcenter")
    private String costCenter;

}
