package com.swisscom.backend.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users", schema = "swisscom_deployment")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(column = "first_name")
    private String firstName;

    @CsvBindByName(column = "last_name")
    private String lastName;

    @CsvBindByName(column = "department")
    private String department;

    @CsvBindByName(column = "birthdate")
    private String birthdate;

    @CsvBindByName(column = "costcenter")
    private String costCenter;
}
