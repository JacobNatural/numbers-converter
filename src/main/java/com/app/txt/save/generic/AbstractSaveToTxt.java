package com.app.txt.save.generic;

import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.save.SaveToTxt;
import lombok.AllArgsConstructor;

import java.util.function.Function;

/**
 * Abstract implementation of the SaveToTxt interface.
 *
 * @param <T> the type of the data objects to be saved to a text file
 */
@AllArgsConstructor
public abstract class AbstractSaveToTxt<T> implements SaveToTxt<T> {

    private final TransferTxt<T> transferTxt;

    /**
     * Save a type T object to a text file.
     *
     * @param filename the name of the file to save
     * @param t        the object to save
     * @param prepare  a function to prepare the object for saving
     */
    public void save(String filename, T t, Function<T, String> prepare) {
        transferTxt.write(filename, t, prepare);
    }
}