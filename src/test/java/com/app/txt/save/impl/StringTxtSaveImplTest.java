package com.app.txt.save.impl;

import com.app.txt.transfer.impl.TransferTxt;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static com.app.data_provider.Data_Provider.CONTENT_DATA;
import static com.app.data_provider.Data_Provider.FILENAME_SAVE;

public class StringTxtSaveImplTest {


    @BeforeAll
    public static void beforeAll() {
         var stringSaveToTxt = new StringTxtSaveImpl(new TransferTxt<>());
        stringSaveToTxt.save(FILENAME_SAVE, CONTENT_DATA, x -> x);
    }


    @Test
    @DisplayName("When created the file and file exist")
    @SneakyThrows
    public void test1(){
        Assertions
                .assertThat(Files.exists(Path.of(FILENAME_SAVE)))
                .isTrue();
    }

    @Test
    @DisplayName("When created the file and has correct data")
    @SneakyThrows
    public void test2(){
        try(var data = Files.lines(Path.of(FILENAME_SAVE))){
            Assertions
                .assertThat(data.collect(Collectors.joining()))
                .isEqualTo(CONTENT_DATA);
        }
    }

    @AfterAll
    @SneakyThrows
    public static void afterAll(){
        Files.delete(Path.of(FILENAME_SAVE));
    }
}
