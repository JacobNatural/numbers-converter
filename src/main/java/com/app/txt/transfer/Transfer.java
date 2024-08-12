package com.app.txt.transfer;

import com.app.parser.LineParser;

import java.util.List;
import java.util.function.Function;

/**
 * Interface for classes intended to read and write data objects of type T to and from a text file.
 *
 * @param <T> The type of the data objects to be transferred.
 * @author your_name
 * @since your_project_version
 */
public interface Transfer<T> {

    /**
     * Read data from a text file and transform it into objects of type T.
     *
     * @param filename   the name of the file to read from
     * @param lineParser a parser used to transform each line of the file into a data object of type T
     * @return a list of objects of type T
     */
    List<T> read(String filename, LineParser<T> lineParser);

    /**
     * Write data to a text file. Takes an object of type T and a function to prepare that object for writing.
     *
     * @param txt     the name of the file to save to
     * @param t       the object to write to the file
     * @param prepare a function to prepare the object for writing
     */
    void write(String txt, T t, Function<T, String> prepare);
}