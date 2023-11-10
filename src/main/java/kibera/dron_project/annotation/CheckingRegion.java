package kibera.dron_project.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import kibera.dron_project.annotation.validator.CheckingRegionValidator;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckingRegionValidator.class)
public @interface CheckingRegion {
    String message() default "Region is not exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
