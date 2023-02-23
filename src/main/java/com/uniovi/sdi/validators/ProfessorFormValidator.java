package com.uniovi.sdi.validators;

import com.uniovi.sdi.entities.Mark;
import com.uniovi.sdi.entities.Professor;
import com.uniovi.sdi.services.MarksService;
import com.uniovi.sdi.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessorFormValidator implements Validator {

    @Autowired
    private ProfessorsService professorsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Mark.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dni","error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","error.empty");
        System.out.println(professor.getDni());

        if(professor.getDni().length()!=9) {
            errors.rejectValue("dni", "Error.professor.dni.length");
        }

        if(!Character.isLetter(professor.getDni().toCharArray()[professor.getDni().length()-1])) {
            errors.rejectValue("dni", "Error.professor.dni.character");
        }

        if(professorsService.getProfessorByDni(professor.getDni())!=null) {
            errors.rejectValue("dni", "Error.professor.dni.duplicate");
        }
    }
}
