package com.app.format;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * RequiredArgsConstructor generates a constructor with 1 parameter for each field that requires special handling.
 * All non-initialized final fields get a parameter, as well as any fields that are marked as @NonNull  that aren't initialized where they are declared.
 * EqualsAndHashCode generates implementations for the equals(Object other) and hashCode() methods inherited by all objects, based on the fields of your class.
 * ToString generates an implementation for the toString() method inherited by all objects, based on the fields of your class.
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Format {

    private final int entrySystemCode;
    private final int expectedSystemCode;
    private final String code;

    /**
     * Checks if the code is in a valid format.
     *
     * @return false if any character in the code is greater or equal to the entrySystemCode, true otherwise
     */
    public boolean validateFormat() {

        for (var bit : code.toCharArray()) {
            if (Character.getNumericValue(bit) >= entrySystemCode) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the entrySystemCode is equal to the expectedSystemCode
     *
     * @return true if they are equal (duplicated), false otherwise
     */
    public boolean isDuplicated() {
        return entrySystemCode == expectedSystemCode;
    }

    /**
     * Transforms the code from the entrySystemCode base to the expectedSystemCode base.
     * <p>
     * If the entrySystemCode and expectedSystemCode are the same (duplicated), no transformation is done and the code is returned as it is.
     *
     * @return the transformed code
     */
    public String transformCode() {

        if (isDuplicated()) {
            return code;
        }

        return Integer
                .toString(
                        Integer.parseInt
                                (code, entrySystemCode), expectedSystemCode);
    }
}
