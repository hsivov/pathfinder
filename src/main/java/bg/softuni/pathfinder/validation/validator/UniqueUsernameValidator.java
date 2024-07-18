package bg.softuni.pathfinder.validation.validator;

import bg.softuni.pathfinder.service.AuthenticationService;
import bg.softuni.pathfinder.validation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final AuthenticationService authenticationService;

    public UniqueUsernameValidator(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (username == null || username.isEmpty()) {
            return true;
        }

        return authenticationService.isUsernameUnique(username);
    }
}
