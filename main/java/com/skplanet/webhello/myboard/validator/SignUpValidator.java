package com.skplanet.webhello.myboard.validator;

import com.skplanet.webhello.myboard.entity.User;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 20.
 * Time: 오전 11:14
 * To change this template use File | Settings | File Templates.
 */
public class SignUpValidator implements Validator,MessageSourceAware {

    @Override
    public void setMessageSource(MessageSource messageSource) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user  = (User) o;
        if(user.getName() == null || user.getName().trim().isEmpty()){
//            errors.rejectValue("writer","required",errorMessage);
            errors.rejectValue("name","required","Name Required");

        }
        if(user.getPw() == null || user.getPw().trim().isEmpty()){
            errors.rejectValue("pw","required","PW Required");
        }
        if(user.getUserid() == null || user.getUserid().trim().isEmpty()){
            errors.rejectValue("userid","required","User ID Required");
        }
        if(user.getNickname() == null || user.getNickname().trim().isEmpty()){
            errors.rejectValue("nickname","required","Nick Name Required");
        }
    }
}
