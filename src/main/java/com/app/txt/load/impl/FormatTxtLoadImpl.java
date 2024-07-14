package com.app.txt.load.impl;

import com.app.formmat.Format;
import com.app.parser.LineParser;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.load.LoadFromTxt;
import com.app.txt.load.generic.AbstractLoadFromTxt;

/**
 * The type Format txt load.
 */
public class FormatTxtLoadImpl extends AbstractLoadFromTxt<Format> implements LoadFromTxt<Format> {
    /**
     * Instantiates a new Format txt load.
     *
     * @param transferTxt the transfer txt
     */
    public FormatTxtLoadImpl(TransferTxt<Format> transferTxt, LineParser<Format> lineParser) {
        super(transferTxt, lineParser);
    }
}
