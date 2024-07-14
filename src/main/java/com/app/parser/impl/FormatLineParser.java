package com.app.parser.impl;

import com.app.formmat.Format;
import com.app.parser.LineParser;
import com.app.validate.Validator;
import lombok.AllArgsConstructor;

/**
 * The type Format line parser.
 */
@AllArgsConstructor
public class FormatLineParser implements LineParser<Format> {

    private final String regex;
    private final Validator<Format> validator;

    @Override
    public Format parse(String line) {

        if(line == null){
            throw new IllegalArgumentException("Line is null");
        }

        if(line.isEmpty()){
            throw new IllegalArgumentException("Line is empty");
        }

        if(!line.matches(regex)){
            throw new IllegalArgumentException("Line format is invalid");
        }

        var splitLine = line.split(" ");

        var format = new Format(Integer.parseInt(splitLine[0]),
                Integer.parseInt(splitLine[1]),
                splitLine[2]);

        Validator.validate(format, validator);

        return format;
    }
}
