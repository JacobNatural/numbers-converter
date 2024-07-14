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
 * The type Transfer txt.
 *
 * @param <T> the type parameter
 */
@RequiredArgsConstructor
public class TransferTxt<T> implements Transfer<T> {

    @Override
    @SneakyThrows
    public List<T> read(String filename, LineParser<T> lineParser) {

        if(filename == null){
            throw new IllegalArgumentException("Filename is null");
        }

        if(lineParser == null){
            throw new IllegalArgumentException("Line parser is null");
        }

        if(filename.isEmpty()){
            throw new IllegalArgumentException("Filename is empty");
        }

         try (var lines = Files.lines(Paths.get(filename))){

           return  lines
                   .map(lineParser::parse)
                   .toList();
        }
    }

    @Override
    @SneakyThrows
    public void write( String filename,T t, Function<T, String> prepare) {

        if(t == null){
            throw new IllegalArgumentException("T is null");
        }

        if(prepare == null){
            throw new IllegalArgumentException("Function is null");
        }

        if(filename == null){
            throw new IllegalArgumentException("Filename is null");
        }
        if(filename.isEmpty()){
            throw new IllegalArgumentException("Filename is empty");
        }

        try (var fw = new FileWriter(filename); var pw = new PrintWriter(fw)){

            pw.println(prepare.apply(t));
        }
    }
}
