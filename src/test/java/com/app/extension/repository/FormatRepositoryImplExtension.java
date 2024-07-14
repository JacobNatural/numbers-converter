package com.app.extension.repository;


import com.app.parser.impl.FormatLineParser;
import com.app.repository.impl.FormatRepositoryImpl;
import com.app.txt.load.impl.FormatTxtLoadImpl;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.validate.impl.FormatValidator;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.nio.file.Paths;
import java.util.Objects;

public class FormatRepositoryImplExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(FormatRepositoryImpl.class);
    }

    @Override
    @SneakyThrows
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        var filename = Paths.get(
                Objects.requireNonNull(
                        getClass()
                                .getClassLoader()
                                .getResource("format_service/formatTest.txt"))
                        .toURI())
                .toString();

        return new FormatRepositoryImpl(
                filename,
                new FormatTxtLoadImpl(
                        new TransferTxt<>(),
                        new FormatLineParser(
                                "[2-9] [2-9] [0-9]+",
                                new FormatValidator())));
    }
}
