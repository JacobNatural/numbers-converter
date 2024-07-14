package com.app.formmat;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The type Format.
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Format {

    private final int entrySystemCode;
    private final int expectedSystemCode;
    private final String code;



    /**
     * Is correct format boolean.
     *
     * @return the boolean
     */
    public boolean validateFormat(){

        for(var bit : code.toCharArray()){
            if(Character.getNumericValue(bit) >= entrySystemCode){
                return false;
            }
        }
        return true;
    }

    /**
     * Is duplicated boolean.
     *
     * @return the boolean
     */
    public boolean isDuplicated(){
        return entrySystemCode == expectedSystemCode;
    }

    /**
     * Transform code string.
     *
     * @return the string
     */
    public String transformCode(){

        if(isDuplicated()){
            return code;
        }

        return Integer
                .toString(
                        Integer.parseInt
                                (code, entrySystemCode), expectedSystemCode);
    }
}
