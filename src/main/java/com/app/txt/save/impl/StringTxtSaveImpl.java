package com.app.txt.save.impl;

import com.app.txt.transfer.impl.TransferTxt;
import com.app.txt.save.SaveToTxt;
import com.app.txt.save.generic.AbstractSaveToTxt;

/**
 * The type String save to txt.
 */
public class StringTxtSaveImpl extends AbstractSaveToTxt<String> implements SaveToTxt<String> {
    /**
     * Instantiates a new String save to txt.
     *
     * @param transferTxt the transfer txt
     */
    public StringTxtSaveImpl(TransferTxt<String> transferTxt) {
        super(transferTxt);
    }
}
