package com.app.txt.load.impl;

import com.app.format.Format;
import com.app.parser.LineParser;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.load.LoadFromTxt;
import com.app.txt.load.generic.AbstractLoadFromTxt;

/**
 * Implementation of the LoadFromTxt interface for loading Format data from a text file.
 * Extends AbstractLoadFromTxt and implements LoadFromTxt.
 */
public class FormatTxtLoadImpl extends AbstractLoadFromTxt<Format> implements LoadFromTxt<Format> {

    /**
     * Constructs an FormatTxtLoadImpl object with the specified transferTxt and lineParser.
     *
     * @param transferTxt Object of class implementing TransferTxt interface
     * @param lineParser Object of class implementing LineParser interface
     */
    public FormatTxtLoadImpl(TransferTxt<Format> transferTxt, LineParser<Format> lineParser) {
        super(transferTxt, lineParser);
    }
}