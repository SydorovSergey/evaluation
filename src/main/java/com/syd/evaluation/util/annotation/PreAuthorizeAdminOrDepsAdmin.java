package com.syd.evaluation.util.annotation;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_DEPARTMENTS')")
public @interface PreAuthorizeAdminOrDepsAdmin {
}
