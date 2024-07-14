package com.app.txt.save.generic;

import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.save.SaveToTxt;
import lombok.AllArgsConstructor;

import java.util.function.Function;

/**
 * The type Abstract save to txt.
 *
 * @param <T> the type parameter
 */
@AllArgsConstructor
public abstract class AbstractSaveToTxt<T> implements SaveToTxt<T> {
    private final TransferTxt<T> transferTxt;

    public void save(String filename, T t, Function<T,String> prepare){
        transferTxt.write(filename, t, prepare);
    }
}
