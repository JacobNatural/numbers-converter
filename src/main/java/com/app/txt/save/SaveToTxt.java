package com.app.txt.save;

import java.util.function.Function;

/**
 * The interface Save to txt.
 *
 * @param <T> the type parameter
 */
public interface SaveToTxt<T> {
    /**
     * Save.
     *
     * @param filename the filename
     * @param t        the t
     * @param prepare  the prepare
     */
    void save(String filename, T t, Function<T,String> prepare);
}
