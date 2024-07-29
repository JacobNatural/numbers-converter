package com.app.txt.load;

import java.util.List;

/**
 * Interface for classes intended to load data objects of type T from a text file.
 *
 * @param <T> The type of the data objects stored in the file.
 */
public interface LoadFromTxt<T> {

    /**
     * Load a list of type T objects from a text file.
     *
     * @param filename the name of the file to load from
     * @return a list of loaded objects of type T
     */
    List<T> load(String filename);
}