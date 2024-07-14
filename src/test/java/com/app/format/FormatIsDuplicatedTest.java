package com.app.format;

import com.app.formmat.Format;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FormatIsDuplicatedTest {
    private static Format format;

    @ParameterizedTest
    @DisplayName("When checking that the post format and expected format are the same")
    @CsvSource({"2,2","3,3","6,6"})
    public void test1(int entrySystemCode,int expectedSystemCode){

        format = new Format(entrySystemCode, expectedSystemCode, "10001");

        Assertions
                .assertThat(format.isDuplicated())
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("When checking that the post format and expected format are different")
    @CsvSource({"2,3","2,3","3,6"})
    public void test2(int entrySystemCode,int expectedSystemCode){

        format = new Format(entrySystemCode, expectedSystemCode, "10001");

        Assertions
                .assertThat(format.isDuplicated())
                .isFalse();
    }
}
