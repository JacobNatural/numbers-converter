package com.app.validate.impl;
import com.app.formmat.Format;
import com.app.validate.Validator;


public class FormatValidator implements Validator<Format> {
    /**
     * The constant DEFAULT_REGEX.
     */


    @Override
    public String validate(Format format) {

        if(!format.validateFormat()){
            return "Types are wrong";
        }
        return null;
    }
}
