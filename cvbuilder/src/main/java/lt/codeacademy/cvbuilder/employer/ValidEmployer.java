package lt.codeacademy.cvbuilder.employer;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEmployer.EmployerValidator.class)
public @interface ValidEmployer {


    String message() default "Invalid data";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class EmployerValidator implements ConstraintValidator<ValidEmployer, EmployerView> {

        @Override
        public boolean isValid(EmployerView employerView,
                               ConstraintValidatorContext constraintValidatorContext) {
            return employerView.getStartDate().isBefore(employerView.getEndDate());
        }
    }
}
