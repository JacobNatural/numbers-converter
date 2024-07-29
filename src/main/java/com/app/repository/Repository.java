package com.app.repository;

import java.util.List;

/**
 * Interface for classes intended to serve as repositories of data objects.
 * @param <T> The type of the data objects stored in the repository.
 */
public interface Repository <T>{

    /**
     * Retrieves all data objects in this repository.
     *
     * @return A list of all data objects. The type of list elements is T.
     */
    List<T> getAll();
}