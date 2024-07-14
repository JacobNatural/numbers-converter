package com.app.validate;

/**
 * The interface Validator.
 *
 * @param <T> the type parameter
 */
public interface Validator <T>{

    /**
     * Validate string.
     *
     * @param t the t
     * @return the string
     */
    String validate(T t);

    /**
     * Validate.
     *
     * @param <T>       the type parameter
     * @param t         the t
     * @param validator the validator
     */
    static <T> void validate(T t, Validator<T> validator){

        var errors = validator.validate(t);

        if(errors != null){
            throw new IllegalArgumentException(errors);
        }
    }
}
