package com.app.txt.load.impl;

import com.app.extension.txt.load.FormatTxtLoadImplExtension;
import com.app.formmat.Format;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static com.app.data_provider.Data_Provider.FILENAME_LOAD;

@ExtendWith(FormatTxtLoadImplExtension.class)
@RequiredArgsConstructor
public class FormatTxtLoadImplTest {

    private final FormatTxtLoadImpl formatTxtLoad;


    @Test
    @DisplayName("When you load correctly")
    @SneakyThrows
    public void test1(){

        var filename = Paths.get(
                Objects.requireNonNull(
                        getClass()
                                .getClassLoader()
                                .getResource(FILENAME_LOAD))
                        .toURI())
                .toString();

        Assertions
                .assertThat(formatTxtLoad.load(filename))
                .isEqualTo(
                        List.of(
                                new Format(2,4,"01011"),
                                new Format(2,4,"01111"),
                                new Format(4 ,2, "13330"))
                );
    }
}
