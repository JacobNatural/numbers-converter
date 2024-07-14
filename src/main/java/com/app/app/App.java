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
import java.nio.file.Paths;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws URISyntaxException {

        var filename = Objects.requireNonNull(App.class.getResource("/data.txt")).toURI();
        var formatValidator = new FormatValidator();
        var formatLineParser = new FormatLineParser("[2-9] [2-9] [0-9]+", formatValidator);
        var transferTxt = new TransferTxt<Format>();
        var formatTxtLoad = new FormatTxtLoadImpl(transferTxt, formatLineParser);
        var formatRepository = new FormatRepositoryImpl(Paths.get(filename).toString(),formatTxtLoad);
        var formatService = new FormatServiceImpl(formatRepository);
        formatService.saveTransformToTxt("transformed.txt", new StringTxtSaveImpl(new TransferTxt<>()), Type.TRANSFORMED);
        formatService.saveTransformToTxt("duplicated.txt", new StringTxtSaveImpl(new TransferTxt<>()), Type.DUPLICATED);


    }
}
