package com.syd.evaluation.persistence.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Department extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -8442775948940777610L;
    private String name;
}
