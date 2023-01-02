package com.syd.evaluation.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Employee extends BaseEntity implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 1554775960000020573L;

    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    private Date birthday;
    @OneToMany(mappedBy = "employee", targetEntity = Role.class, fetch = FetchType.EAGER)
    private Set<Role> roles;
    @OneToMany(mappedBy = "employee", targetEntity = Department.class, fetch = FetchType.EAGER)
    private Set<Department> departments;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return getActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return getActive();
    }

    @Override
    public boolean isEnabled() {
        return getActive();
    }
}
