package com.uniovi.sdi.validators;

import com.uniovi.sdi.entities.User;
import com.uniovi.sdi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SignUpFormValidator  implements Validator {

    @Autowired
    private UsersService usersService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dni","error.empty");

        if(user.getDni().length()<5 || user.getDni().length()>24) {
            errors.rejectValue("dni", "Error.signuo.dni.length");
        }
        if(usersService.getUserByDni(user.getDni())!=null) {
            errors.rejectValue("dni", "Error.signuo.dni.duplicate");
        }
        if(user.getName().length()<5 || user.getName().length()>24) {
            errors.rejectValue("name", "Error.signuo.name.length");
        }
        if(user.getLastName().length()<5 || user.getLastName().length()>24) {
            errors.rejectValue("lastName", "Error.signuo.lastName.length");
        }
        if(user.getPassword().length()<5 || user.getPassword().length()>24) {
            errors.rejectValue("password", "Error.signuo.password.length");
        }
        if(user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Error.signup.passwordConfirm.coincidence");
        }
    }

}
