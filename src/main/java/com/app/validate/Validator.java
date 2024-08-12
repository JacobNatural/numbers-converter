package com.app.validate;

/**
 * Interface for classes intended to validate data objects of type T.
 *
 * @param <T> The type of the data objects to be validated.
 * @author your_name
 * @since your_project_version
 */
public interface Validator<T> {

    /**
     * Validate an object of type T and returns an error message if validation fails.
     *
     * @param t the object to be validated
     * @return a String representing an error message if validation fails, null otherwise
     */
    String validate(T t);

    /**
     * Static method to validate an object and throws an IllegalArgumentException if validation fails.
     *
     * @param t         the object to be validated
     * @param validator the validator to use for validation
     * @throws IllegalArgumentException if validation fails
     */
    static <T> void validate(T t, Validator<T> validator) {

        var errors = validator.validate(t);

        if (errors != null) {
            throw new IllegalArgumentException(errors);
        }
    }
}
