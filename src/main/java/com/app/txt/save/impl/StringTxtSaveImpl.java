package com.app.txt.save.impl;

import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.save.SaveToTxt;
import com.app.txt.save.generic.AbstractSaveToTxt;

/**
 * Implementation of the SaveToTxt interface for saving String data to a text file.
 * Extends AbstractSaveToTxt and implements SaveToTxt.
 */
public class StringTxtSaveImpl extends AbstractSaveToTxt<String> implements SaveToTxt<String> {

    /**
     * Constructs a StringTxtSaveImpl object with specified transferTxt.
     *
     * @param transferTxt Object of class implementing TransferTxt interface
     */
    public StringTxtSaveImpl(TransferTxt<String> transferTxt) {
        super(transferTxt);
    }
}