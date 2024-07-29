package com.app.parser.impl;

import com.app.format.Format;
import com.app.parser.LineParser;
import com.app.validate.Validator;
import lombok.AllArgsConstructor;

/**
 * Implementation of the LineParser interface specific to the Format class.
 * This class takes in a line and a regex string, from which it can create and validate a new instance of Format.
 */
@AllArgsConstructor
public class FormatLineParser implements LineParser<Format> {

    private final String regex;
    private final Validator<Format> validator;

    /**
     * Parses a line to create a new instance of Format and validates it using the provided validator.
     *
     * @param line The input string to be parsed
     * @return A new instance of Format parsed from the input line
     * @throws IllegalArgumentException a) if the line is null b) if the line is empty c) if the line format does not match the provided regex
     */
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