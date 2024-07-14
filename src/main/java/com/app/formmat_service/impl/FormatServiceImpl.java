package com.app.formmat_service.impl;

import com.app.formmat_service.FormatService;
import com.app.repository.impl.FormatRepositoryImpl;
import com.app.txt.save.SaveToTxt;
import com.app.type.Type;
import lombok.AllArgsConstructor;
import lombok.ToString;
import java.util.*;

/**
 * The type Format service.
 */

@AllArgsConstructor()
public class FormatServiceImpl implements FormatService<Type, String> {

    private final FormatRepositoryImpl formatRepository;

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

