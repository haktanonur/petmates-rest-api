package edu.estu.petmates.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({   ElementType.FIELD   })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {
    String message() default "e-mail already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
