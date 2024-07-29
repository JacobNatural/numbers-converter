package com.app.format;

import com.app.format.Format;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FormatTransformCodeTest {

    private static Format format;

    @ParameterizedTest
    @DisplayName("When transform from enter system code to expected system code")
    @CsvFileSource(resources = "/format/format_transform.csv")
    public void test1(int entrySystemCode, int expectedSystemCode, String code, String expectedCode){

        format = new Format(entrySystemCode, expectedSystemCode, code);

        Assertions
                .assertThat(format.transformCode())
                .isEqualTo(expectedCode);
    }

}
