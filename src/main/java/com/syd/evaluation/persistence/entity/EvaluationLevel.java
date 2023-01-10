package com.syd.evaluation.persistence.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class EvaluationLevel extends BaseEntity{

    private String name;
}
