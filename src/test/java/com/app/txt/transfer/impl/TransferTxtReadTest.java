package com.app.txt.transfer.impl;

import com.app.extension.parser.FormatLineParserExtension;
import com.app.extension.txt.transfer.TransferTxtExtension;
import com.app.format.Format;
import com.app.parser.impl.FormatLineParser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static com.app.data_provider.Data_Provider.FILENAME_LOAD;

@ExtendWith({TransferTxtExtension.class,FormatLineParserExtension.class})
@AllArgsConstructor
public class TransferTxtReadTest {

    private final TransferTxt<Format> transferTxt;
    private final FormatLineParser formatLineParser;

    @Test
    @DisplayName("When the filename is null")
    public void test1(){
        Assertions.assertThatThrownBy(
                () -> transferTxt.read(
                        null,
                        formatLineParser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is null");
    }

    @Test
    @DisplayName("When the filename is empty")
    public void test2(){
        Assertions.assertThatThrownBy(
                        () -> transferTxt.read(
                                "",
                                formatLineParser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is empty");
    }

    @Test
    @DisplayName("When the line parser is null")
    public void test3(){
        Assertions.assertThatThrownBy(
                        () -> transferTxt.read(
                                "data.txt",
                                null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line parser is null");
    }

    @Test
    @DisplayName("When the file not exist")
    public void test4(){
        Assertions.assertThatThrownBy(
                () -> transferTxt.read(
                        "data01.txt",
                        formatLineParser
                        )
        )
                .isInstanceOf(NoSuchFileException.class);
    }

    @SneakyThrows
    @Test
    @DisplayName("When you read it correctly")
    public void test5(){

        var path = Paths.get
                (Objects.requireNonNull(
                        getClass().getClassLoader().getResource(FILENAME_LOAD)).toURI());

        Assertions.assertThat(transferTxt.read(
                path.toString(),
                formatLineParser)
        )
                .isEqualTo(List.of(
                        new Format(2,4,"01011"),
                        new Format(2,4,"01111"),
                        new Format(4 ,2, "13330")
                ));
    }
}
