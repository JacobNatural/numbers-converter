package com.app.formmat_service;

import com.app.txt.save.SaveToTxt;
import java.util.Map;

/**
 * A service interface for transforming and saving data.
 *
 * @param <T> the type of data to be transformed
 * @param <U> the type of transformed data
 */
public interface FormatService<T, U>{

   /**
    * Saves transformed data to a text file.
    *
    * @param filename the name of the file where the transformed data will be stored
    * @param saveToTxt object of class implementing SaveToTxt interface
    * @param t the data to be transformed and saved
    */
   void saveTransformToTxt(String filename, SaveToTxt<U> saveToTxt, T t);

   /**
    * Transforms data.
    *
    * @return Map of transformed data. Key is of type T, value is of type U
    */
   Map<T, U> transform();
}