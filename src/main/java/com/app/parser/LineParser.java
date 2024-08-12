package com.app.parser;

/**
 * Interface for classes that parse lines of text to create new instances of a specific type.
 *
 * @param <T> the type of object created by parsing a line of text
 */
public interface LineParser<T> {

    /**
     * Parses a line of text to create a new instance of type T.
     *
     * @param line the line of text to parse
     * @return a new instance of type T
     */
    T parse(String line);
}