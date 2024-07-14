package com.app.txt.load;
import java.util.List;

/**
 * The interface Load from txt.
 *
 * @param <T> the type parameter
 */
public interface LoadFromTxt<T> {
    /**
     * Load list.
     *
     * @param filename the filename
     * @return the list
     */
    List<T> load(String filename);
}
