package com.pma.validators;

import com.pma.deo.EmployeeRepository;
import com.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    EmployeeRepository empRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Employee emp = empRepo.findByEmail(value);

        if(emp != null)
            return false;
        else
            return true;
    }
}
