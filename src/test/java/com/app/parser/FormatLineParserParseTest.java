package com.app.parser;

import com.app.extension.parser.FormatLineParserExtension;
import com.app.formmat.Format;
import com.app.parser.impl.FormatLineParser;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(FormatLineParserExtension.class)
@RequiredArgsConstructor
public class FormatLineParserParseTest {

    private final FormatLineParser formatLineParser;

    @Test
    @DisplayName("When the line is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> formatLineParser.parse(null)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line is null");
    }

    @Test
    @DisplayName("When the line is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> formatLineParser.parse("")
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line is empty");
    }

    @ParameterizedTest
    @DisplayName("When the line is invalid")
    @CsvSource({"2,3,110","10101 2 2","2 1020 3","233121"})
    public void test3(String line){
        Assertions
                .assertThatThrownBy(
                        () -> formatLineParser.parse(line)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line format is invalid");
    }

    @ParameterizedTest
    @DisplayName("When the types are wrong")
    @CsvSource({"2 3 12010", "4 2 125120", "3 3 122223"})
    public void test4(String line){
        Assertions
                .assertThatThrownBy(
                        () -> formatLineParser.parse(line)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Types are wrong");
    }

    @ParameterizedTest
    @DisplayName("When parse correctly")
    @CsvSource({"2 3 11010", "4 2 123120", "3 3 122222"})
    public void test5(String line){

        var split = line.split(" ");
        Assertions
                .assertThat(
                        formatLineParser.parse(line)
                ).isEqualTo(
                        new Format(
                                Integer.parseInt(split[0]),
                                Integer.parseInt(split[1]),
                                split[2]));
    }
}

