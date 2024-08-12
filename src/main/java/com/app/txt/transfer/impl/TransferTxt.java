package com.app.txt.transfer.impl;

import com.app.parser.LineParser;
import com.app.txt.transfer.Transfer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

/**
 * Implementation of the Transfer interface for transferring data of type T to and from a text file.
 *
 * @param <T> The type of data to be transferred.
 */
@RequiredArgsConstructor
public class TransferTxt<T> implements Transfer<T> {

    /**
     * Reads data from a text file and transforms it into objects of type T.
     *
     * @param filename   the name of the file to read from
     * @param lineParser the parser used to transform each line of the file into a data object of type T
     * @return a List of objects of type T representing the data in the file
     * @throws IllegalArgumentException if the filename or the lineParser is null.
     */
    @Override
    @SneakyThrows
    public List<T> read(String filename, LineParser<T> lineParser) {

        if (filename == null) {
            throw new IllegalArgumentException("Filename is null");
        }

        if (lineParser == null) {
            throw new IllegalArgumentException("Line parser is null");
        }

        if (filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is empty");
        }

        try (var lines = Files.lines(Paths.get(filename))) {

            return lines
                    .map(lineParser::parse)
                    .toList();
        }
    }

    /**
     * Writes data to a text file. Takes a single object of type T and a function to prepare that object for writing.
     *
     * @param filename the name of the file to write to
     * @param t        the object to be written to the file
     * @param prepare  a function that prepares the object for writing as a string to the file
     * @throws IllegalArgumentException if the filename, the object t, or the prepare function are null.
     */
    @Override
    @SneakyThrows
    public void write(String filename, T t, Function<T, String> prepare) {

        if (t == null) {
            throw new IllegalArgumentException("T is null");
        }

        if (prepare == null) {
            throw new IllegalArgumentException("Function is null");
        }

        if (filename == null) {
            throw new IllegalArgumentException("Filename is null");
        }
        if (filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is empty");
        }

        try (var fw = new FileWriter(filename); var pw = new PrintWriter(fw)) {

            pw.println(prepare.apply(t));
        }
    }
}
