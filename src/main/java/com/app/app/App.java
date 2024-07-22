package com.app.app;

import com.app.formmat.Format;
import com.app.formmat_service.impl.FormatServiceImpl;
import com.app.parser.impl.FormatLineParser;
import com.app.repository.impl.FormatRepositoryImpl;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.load.impl.FormatTxtLoadImpl;
import com.app.txt.save.impl.StringTxtSaveImpl;
import com.app.type.Type;
import com.app.validate.impl.FormatValidator;

import java.net.URISyntaxException;


public class App {
    public static void main(String[] args) throws URISyntaxException {

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
        var formatRepository = new FormatRepositoryImpl(filename,formatTxtLoad);

        // FORMAT SERVICE
        var formatService = new FormatServiceImpl(formatRepository);

        // FILE PROCESSING WITH SAVE TO TXT
        formatService.saveTransformToTxt("transformed.txt", stringTxtSave, Type.TRANSFORMED);
        formatService.saveTransformToTxt("duplicated.txt", stringTxtSave, Type.DUPLICATED);

    }
}
