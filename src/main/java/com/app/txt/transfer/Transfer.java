package com.app.txt.transfer;

import com.app.parser.LineParser;

import java.util.List;
import java.util.function.Function;

/**
 * The interface Transfer.
 *
 * @param <T> the type parameter
 */
public interface Transfer <T>{
    /**
     * Read list.
     *
     * @param filename   the filename
     * @param lineParser the line parser
     * @return the list
     */
    List<T> read(String filename, LineParser<T> lineParser);

    /**
     * Write.
     *
     * @param txt     the txt
     * @param t       the t
     * @param prepare the prepare
     */
    void write(String txt, T t, Function<T, String> prepare);
}
