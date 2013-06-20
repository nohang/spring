package com.skplanet.webhello.myboard.validator;

import com.skplanet.webhello.myboard.entity.Board;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 17.
 * Time: 오후 4:23
 * To change this template use File | Settings | File Templates.
 */
public class BoardValidator implements Validator,MessageSourceAware{

    private MessageSource messageSource;
    @Override
    public boolean supports(Class<?> aClass) {
        return Board.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        String errorMessage = messageSource.getMessage("error",new Object[0], Locale.getDefault());
        Board board  = (Board) o;
        if(board.getWriter() == null || board.getWriter().trim().isEmpty()){
//            errors.rejectValue("writer","required",errorMessage);
            errors.rejectValue("writer","required","Writer Required");

        }
        if(board.getPw() == null || board.getPw().trim().isEmpty()){
            errors.rejectValue("pw","required","PW Required");
        }
        if(board.getTitle() == null || board.getTitle().trim().isEmpty()){
            errors.rejectValue("title","required","Title Required");
        }
        if(board.getContent() == null || board.getContent().trim().isEmpty()){
            errors.rejectValue("content","required","Content Required");
        }
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
       this.messageSource = messageSource;
    }
}
