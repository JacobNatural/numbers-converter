package com.app.txt.load.generic;

import com.app.parser.LineParser;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.load.LoadFromTxt;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;

/**
 * The type Abstract load from txt.
 *
 * @param <T> the type parameter
 */
@AllArgsConstructor
public abstract class AbstractLoadFromTxt<T> implements LoadFromTxt<T> {

    /**
     * The Transfer txt.
     */
    private final TransferTxt<T> transferTxt;
    private final LineParser<T> lineParser;

    @Override
    public List<T> load(String filename) {
        return transferTxt.read(filename,lineParser);
    }
}
