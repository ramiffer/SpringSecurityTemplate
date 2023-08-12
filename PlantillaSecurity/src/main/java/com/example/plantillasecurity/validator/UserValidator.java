package com.example.plantillasecurity.validator;

import com.example.plantillasecurity.models.User;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> c) {
        return User.class.equals(c);
    }

    @Override
    public void validate(Object o, Errors e){
        User user = (User) o;

            if(!user.getPasswordConfirmation().equals(user.getPassword())){
                e.rejectValue("passwordConfirmation", "Match");
            }
    }

}
