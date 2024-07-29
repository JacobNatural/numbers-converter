package com.app.validate.impl;
import com.app.format.Format;
import com.app.validate.Validator;

/**
 * Represents an implementation of the Validator interface for validating formats.
 */
public class FormatValidator implements Validator<Format> {

    /**
     * Validates a format. Returns an error message if validation fails, null otherwise.
     *
     * @param format the format to validate
     * @return an error message if the format validation fails, null otherwise
     */
    @Override
    public String validate(Format format) {

        if(!format.validateFormat()){
            return "Types are wrong";
        }
        return null;
    }
}
