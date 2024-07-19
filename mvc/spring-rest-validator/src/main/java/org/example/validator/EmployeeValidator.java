package org.example.validator;

import org.example.model.EmployeeModel;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeValidator implements ConstraintValidator<ValidEmployee, EmployeeModel> {

    @Override
    public void initialize(ValidEmployee constraintAnnotation) {
        // Initialization code, if necessary
    }

    @Override
    public boolean isValid(EmployeeModel employee, ConstraintValidatorContext context) {
        if (employee == null) {
            return true; // or false depending on your null handling strategy
        }

        boolean isValidName = isValidName(employee, context) ;
        boolean isValidId = isValidId(employee, context);

        return isValidName && isValidId;
    }

    private boolean isValidName(EmployeeModel employee, ConstraintValidatorContext context) {
        boolean isValid = true;
        // Validate name
        String name = employee.getName();
        if (name == null || name.isEmpty()) {
            context.buildConstraintViolationWithTemplate("Name cannot be empty")
                    .addPropertyNode("name")
                    .addConstraintViolation();
            isValid = false;
        } else if (name.length() < 2 || name.length() > 5) {
            context.buildConstraintViolationWithTemplate("Name must be between 2 and 5 characters")
                    .addPropertyNode("name")
                    .addConstraintViolation();
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidId(EmployeeModel employee, ConstraintValidatorContext context) {
        boolean isValid = true;
        // Validate name
        if(employee.getId() <= 0){
            context.buildConstraintViolationWithTemplate("Id should not be -ve")
                    .addPropertyNode("id")
                    .addConstraintViolation();
            isValid=false;
        }
        else if(!(employee.getId() > 2 && employee.getId() < 1000)){
            context.buildConstraintViolationWithTemplate("Id must be between 2 and 1000")
                    .addPropertyNode("id")
                    .addConstraintViolation();
            isValid = false;
        }
        return isValid;
    }
}
