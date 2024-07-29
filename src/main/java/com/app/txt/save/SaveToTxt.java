package com.app.txt.save;

import java.util.function.Function;

/**
 * Interface for classes intending to save data objects of type T to a text file.
 *
 * @param <T> The type of the data objects to be saved.
 */
public interface SaveToTxt<T> {

    /**
     * Save an object of type T to a text file.
     *
     * @param filename the name of the file to save to
     * @param t the object to save
     * @param prepare a function to prepare the object for saving
     */
    void save(String filename, T t, Function<T,String> prepare);
}