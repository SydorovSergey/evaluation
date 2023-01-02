package com.syd.evaluation.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Role extends BaseEntity implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = -3827849534970046318L;

    private String name;

    @Override
    public String getAuthority() {
        return getName();
    }

    @ManyToOne(optional = false)
    private Employee employee;
}
