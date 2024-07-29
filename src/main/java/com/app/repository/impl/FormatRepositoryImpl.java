package com.app.repository.impl;

import com.app.format.Format;
import com.app.repository.Repository;
import com.app.txt.load.LoadFromTxt;

import java.util.List;

/**
 * Implementation of the Repository interface for the Format class.
 */
public class FormatRepositoryImpl implements Repository<Format> {

    private final List<Format> formats;

    /**
     * Constructor loads formats data from a txt file
     *
     * @param filename the name of the txt file from which format data are loaded
     * @param load object of class implementing LoadFromTxt interface
     */
    public FormatRepositoryImpl(String filename, LoadFromTxt<Format> load){
        this.formats = load.load(filename);
    }

    /**
     * Retrieves all format data.
     *
     * @return List of format data
     */
    @Override
    public List<Format> getAll() {
        return formats;
    }
}