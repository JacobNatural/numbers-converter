package com.app.txt.transfer.impl;

import com.app.extension.format.FormatExtension;
import com.app.extension.txt.transfer.TransferTxtExtension;
import com.app.format.Format;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.nio.file.Files;
import java.nio.file.Path;
import static com.app.data_provider.Data_Provider.FILENAME_SAVE;

@ExtendWith({TransferTxtExtension.class, FormatExtension.class})
@RequiredArgsConstructor
public class TransferTxtWriteTest {
    private final TransferTxt<Format> transferTxt;
    private final Format format;

    @Test
    @DisplayName("When the filename is null")
    public void test1(){
        Assertions.assertThatThrownBy(
                () -> transferTxt.write(null, format, Format::toString)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is null");
    }

    @Test
    @DisplayName("When the format is null")
    public void test2(){
        Assertions.assertThatThrownBy(
                        () -> transferTxt.write(FILENAME_SAVE, null, Format::toString)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("T is null");
    }

    @Test
    @DisplayName("When the function is null")
    public void test3(){
        Assertions.assertThatThrownBy(
                        () -> transferTxt.write(FILENAME_SAVE, format, null)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Function is null");
    }

    @Test
    @DisplayName("When the filename is empty")
    public void test4(){
        Assertions.assertThatThrownBy(
                        () -> transferTxt.write("", format, Format::toString)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is empty");
    }

    @Test
    @DisplayName("When the file is created and no exception is thrown")
    @SneakyThrows
    public void test5(){
        Assertions.assertThatNoException()
                .isThrownBy(
                        () -> transferTxt.write(FILENAME_SAVE, format, Format::toString));

    }

    @Test
    @DisplayName("When the file exists")
    @SneakyThrows
    public void test6(){

        transferTxt.write(FILENAME_SAVE, format, Format::toString);
        Assertions.assertThat(Files.exists(Path.of(FILENAME_SAVE)))
                .isTrue();
    }

    @AfterAll
    @SneakyThrows
    public static void afterAll(){
        Files.delete(Path.of(FILENAME_SAVE));
    }
}
