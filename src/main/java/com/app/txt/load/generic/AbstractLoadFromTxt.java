package com.app.txt.load.generic;

import com.app.parser.LineParser;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.load.LoadFromTxt;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Abstract implementation of the LoadFromTxt interface.
 *
 * @param <T> the type of the data objects stored in the text file
 */
@AllArgsConstructor
public abstract class AbstractLoadFromTxt<T> implements LoadFromTxt<T> {

    private final TransferTxt<T> transferTxt;
    private final LineParser<T> lineParser;

    /**
     * Load a list of type T objects from a text file.
     *
     * @param filename the name of the file to load from
     * @return a list of loaded objects of type T
     */
    @Override
    public List<T> load(String filename) {
        return transferTxt.read(filename, lineParser);
    }
}