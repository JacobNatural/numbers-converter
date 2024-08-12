package com.app.app;

import com.app.format.Format;
import com.app.format_service.impl.FormatServiceImpl;
import com.app.parser.impl.FormatLineParser;
import com.app.repository.impl.FormatRepositoryImpl;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.load.impl.FormatTxtLoadImpl;
import com.app.txt.save.impl.StringTxtSaveImpl;
import com.app.type.Type;
import com.app.validate.impl.FormatValidator;

/**
 * Represents the main entry point of the application.
 * <p>
 * This class is responsible for :
 * - defining filename and format validator
 * - setting up the parser with a regular expression and the validator
 * - initializing format loading from TXT file, and saving procedures to TXT file
 * - initializing the format repository with the filename and the formatTxtLoad object
 * - initializing the format service with the above initialized format repository
 * And finally, calling the save transform to TXT method from the format service
 */
public class App {

    /**
     * The main method of the program.
     *
     * @param args command-line arguments. No usage of command-line arguments in current implementation.
     */
    public static void main(String[] args) {

        // FILENAME
        var filename = "data.txt";

        // VALIDATE
        var formatValidator = new FormatValidator();

        // PARSER
        var formatLineParser = new FormatLineParser("[2-9] [2-9] [0-9]+", formatValidator);

        // LOAD FROM TXT
        var transferFromTxt = new TransferTxt<Format>();
        var formatTxtLoad = new FormatTxtLoadImpl(transferFromTxt, formatLineParser);

        // SAVE TO TXT
        var transferToTxt = new TransferTxt<String>();
        var stringTxtSave = new StringTxtSaveImpl(transferToTxt);

        // REPOSITORY
        var formatRepository = new FormatRepositoryImpl(filename, formatTxtLoad);

        // FORMAT SERVICE
        var formatService = new FormatServiceImpl(formatRepository);

        // FILE PROCESSING WITH SAVE TO TXT
        formatService.saveTransformToTxt("transformed.txt", stringTxtSave, Type.TRANSFORMED);
        formatService.saveTransformToTxt("duplicated.txt", stringTxtSave, Type.DUPLICATED);

    }
}
