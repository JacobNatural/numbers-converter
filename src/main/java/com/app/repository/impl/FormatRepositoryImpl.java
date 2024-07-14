package com.app.repository.impl;

import com.app.formmat.Format;
import com.app.repository.Repository;
import com.app.txt.load.LoadFromTxt;
import lombok.ToString;

import java.util.List;


/**
 * The type Format repository.
 */
public class FormatRepositoryImpl implements Repository<Format> {

    private final List<Format> formats;

    /**
     * Instantiates a new Format repository.
     *
     * @param filename the filename
     * @param load     the load
     */
    public FormatRepositoryImpl(String filename, LoadFromTxt<Format> load){
        this.formats = load.load(filename);
    }

    @Override
    public List<Format> getAll() {
        return formats;
    }
}
