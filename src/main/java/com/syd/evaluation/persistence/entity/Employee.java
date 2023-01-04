package com.syd.evaluation.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Employee extends BaseEntity implements Serializable, UserDetails {


    @Serial
    private static final long serialVersionUID = -5653032393880179646L;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthday;


    @OneToMany(mappedBy = "employee", targetEntity = Role.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Role> roles;

    @OneToMany(mappedBy = "employee", targetEntity = Department.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Department> departments;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
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
