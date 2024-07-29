package com.app.format;

import com.app.format.Format;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FormatIsCorrectFormatTest {

    private static Format format;

    @ParameterizedTest
    @DisplayName("When the class format is not the correct validate")
    @CsvFileSource(resources = "/format/format_wrong.csv")
    public void test1(int entrySystemCode, int expectedSystemCode, String code){

        format = new Format(entrySystemCode,expectedSystemCode,code);

        Assertions
                .assertThat(format.validateFormat())
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("When class format is the correct validate")
    @CsvFileSource(resources = "/format/format_correct.csv")
    public void test2(int entrySystemCode, int expectedSystemCode, String code){

        format = new Format(entrySystemCode,expectedSystemCode,code);

        Assertions
                .assertThat(format.validateFormat())
                .isTrue();
    }
}
