package com.app.formmat_service.impl;

import com.app.formmat_service.FormatService;
import com.app.repository.impl.FormatRepositoryImpl;
import com.app.txt.save.SaveToTxt;
import com.app.type.Type;
import lombok.AllArgsConstructor;
import java.util.*;

/**
 * Implementation of the FormatService interface.
 * This class is responsible for the transformation and storage of types.
 */
@AllArgsConstructor()
public class FormatServiceImpl implements FormatService<Type, String> {

    private final FormatRepositoryImpl formatRepository;

    /**
     * Saves transformed data to a text file.
     *
     * @param filename the name of the file where the transformed data will be stored
     * @param saveToTxt object of class implementing SaveToTxt interface
     * @param type the type of data to save
     * @throws IllegalArgumentException if saveToTxt or type is null
     */
    public void saveTransformToTxt(
            String filename, SaveToTxt<String> saveToTxt, Type type){

        if(saveToTxt == null){
            throw new IllegalArgumentException("Save is null");
        }

        if(type == null){
            throw new IllegalArgumentException("Type is null");
        }

        saveToTxt.save(filename, transform().get(type),x -> x);
    }

    /**
     * Transforms data retrieved from a FormatRepositoryImpl.
     *
     * @return Map of transformed data by type of data (DUPLICATED or TRANSFORMED). Key is the type, value is the transformed data
     */
    public Map<Type, String> transform() {

        var transformedData = new EnumMap<Type, String>(Type.class);

        formatRepository
                .getAll()
                .forEach(formmat -> {
                        transformedData.merge(
                                formmat.isDuplicated() ? Type.DUPLICATED : Type.TRANSFORMED,
                                formmat.transformCode(),
                                (v1, v2) -> STR."\{v1},\{v2}"
                        );
                });
        return transformedData;
    }
}