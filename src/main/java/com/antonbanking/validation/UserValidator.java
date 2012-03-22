package com.antonbanking.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.antonbanking.business.User;

public class UserValidator implements Validator
{

    @Override
    public boolean supports(Class<?> clazz)
    {
        return clazz.isInstance(User.class);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.name.empty");
    }

}
