package com.app.repository;

import com.app.extension.repository.FormatRepositoryImplExtension;
import com.app.format.Format;
import com.app.repository.impl.FormatRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(FormatRepositoryImplExtension.class)
@RequiredArgsConstructor
public class FormatRepositoryImplGetAllTest {

    private final FormatRepositoryImpl formatRepository;

    @Test
    @DisplayName("When read and get correct data")
    public void test1(){
        Assertions
                .assertThat(formatRepository.getAll())
                .isEqualTo(
                        List.of(
                        new Format(2,4,"01011"),
                        new Format(2,4,"01111"),
                        new Format(4 ,2, "13330")
                ));
    }
}
