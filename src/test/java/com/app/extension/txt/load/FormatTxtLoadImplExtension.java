package com.app.extension.txt.load;

import com.app.parser.impl.FormatLineParser;
import com.app.txt.load.impl.FormatTxtLoadImpl;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.validate.impl.FormatValidator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class FormatTxtLoadImplExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(FormatTxtLoadImpl.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new FormatTxtLoadImpl(
                new TransferTxt<>(),
                new FormatLineParser("[2-9] [2-9] [0-9]+",
                        new FormatValidator()));
    }
}
