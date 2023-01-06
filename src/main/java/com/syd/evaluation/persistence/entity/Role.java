package com.syd.evaluation.persistence.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Role extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1013669978317731003L;
    private String name;
}
