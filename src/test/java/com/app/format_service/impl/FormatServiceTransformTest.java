package com.app.format_service.impl;

import com.app.formmat.Format;
import com.app.formmat_service.impl.FormatServiceImpl;
import com.app.repository.impl.FormatRepositoryImpl;
import com.app.type.Type;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class FormatServiceTransformTest {

    @Mock
    private FormatRepositoryImpl formatRepository;

    @InjectMocks
    private FormatServiceImpl formatService;

    @Test
    @DisplayName("When the input system code and expected code are the same")
    public void test1(){

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(2,3,"10101"),
                        new Format(3,5,"12022"),
                        new Format(4,7,"10301")
                ));

        Assertions
                .assertThat(formatService.transform())
                .isEqualTo(Map.of(Type.TRANSFORMED,"210,1033,614"));
    }

    @Test
    @DisplayName("When the input system code and expected code are different")
    public void test2(){

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(2,2,"10101"),
                        new Format(3,3,"12022"),
                        new Format(4,4,"10301")
                ));

        Assertions
                .assertThat(formatService.transform())
                .isEqualTo(Map.of(Type.DUPLICATED,"10101,12022,10301"));
    }

    @Test
    @DisplayName("When input system code and expected system code are the same and different")
    public void test3(){

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(2,3,"10101"),
                        new Format(3,5,"12022"),
                        new Format(4,7,"10301"),
                        new Format(2,2,"10101"),
                        new Format(3,3,"12022"),
                        new Format(4,4,"10301")
                ));

        Assertions
                .assertThat(formatService.transform())
                .isEqualTo(Map.of(
                        Type.TRANSFORMED,"210,1033,614",
                        Type.DUPLICATED,"10101,12022,10301"));
    }
}
