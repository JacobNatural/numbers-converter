package com.app.formmat_service;

import com.app.repository.impl.FormatRepositoryImpl;
import com.app.txt.save.SaveToTxt;
import com.app.type.Type;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * The interface Format service.
 *
 * @param <T> the type parameter
 * @param <U> the type parameter
 */
public interface FormatService<T, U>{

   /**
    * Save transform to txt.
    *
    * @param filename  the filename
    * @param saveToTxt the save to txt
    * @param t         the t
    */
   void saveTransformToTxt(String filename, SaveToTxt<U> saveToTxt, T t);

   /**
    * Transform map.
    *
    * @return the map
    */
   Map<T, U> transform();
}

