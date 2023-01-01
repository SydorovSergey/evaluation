package com.syd.evaluation.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Employee extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    private Date birthday;
}
