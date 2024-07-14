package com.app.format_service.impl;

import com.app.data_provider.Data_Provider;
import com.app.formmat.Format;
import com.app.formmat_service.impl.FormatServiceImpl;
import com.app.repository.impl.FormatRepositoryImpl;
import com.app.txt.save.impl.StringTxtSaveImpl;
import com.app.txt.transfer.impl.TransferTxt;
import com.app.type.Type;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class FormatServiceSaveTransformToTxtTest {
    @Mock
    private FormatRepositoryImpl formatRepository;

    @InjectMocks
    private FormatServiceImpl formatService;

    //private String FILENAME = "datatest.txt";

    private static StringTxtSaveImpl SAVE = new StringTxtSaveImpl(new TransferTxt<>());

    @Test
    @DisplayName("When filename is null")
    public void test1(){

        Mockito
                .when(formatRepository.getAll())
                        .thenReturn(List.of(new Format(3,5,"1221")));

        Assertions
                .assertThatThrownBy(
                        () -> formatService.saveTransformToTxt(null, SAVE, Type.TRANSFORMED)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is null");
    }

    @Test
    @DisplayName("When filename is empty")
    public void test2(){

        Mockito
                .when(formatRepository.getAll())
                        .thenReturn(List.of(new Format(3,5,"1221")));

        Assertions
                .assertThatThrownBy(
                        () -> formatService.saveTransformToTxt("", SAVE, Type.TRANSFORMED)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is empty");
    }

    @Test
    @DisplayName("When save is null")
    public void test3(){

            lenient().when(formatRepository.getAll())
                        .thenReturn(List.of(new Format(3,5,"1221")));

        Assertions
                .assertThatThrownBy(
                        () -> formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, null, Type.TRANSFORMED))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Save is null");
    }

    @Test
    @DisplayName("When type is null")
    public void test4(){

        lenient().when(formatRepository.getAll())
                .thenReturn(List.of(new Format(3,5,"1221")));

        Assertions
                .assertThatThrownBy(
                        () -> formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, SAVE, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Type is null");
    }

    @Test
    @DisplayName("When transform from entry code system to expected code system and save to file")
    public void test5(){

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(3,5,"1221"),
                        new Format(4,5,"1321")));

        formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, SAVE, Type.TRANSFORMED);

        Assertions.assertThat(Files.exists(Path.of(Data_Provider.FILENAME_SAVE)))
                .isTrue();
    }

    @Test
    @DisplayName("When check the systems code are duplicated and save to file")
    public void test6(){

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(5,5,"1221"),
                        new Format(5,5,"1321")));

        formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, SAVE, Type.DUPLICATED);

        Assertions.assertThat(Files.exists(Path.of(Data_Provider.FILENAME_SAVE)))
                .isTrue();
    }

    @Test
    @DisplayName("When save transformed and transformed is null")
    public void test7(){

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(5,5,"1221"),
                        new Format(5,5,"1321")));

        Assertions.assertThatThrownBy(
                () -> formatService.saveTransformToTxt(
                        Data_Provider.FILENAME_SAVE,SAVE, Type.TRANSFORMED))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("T is null");
    }

    @Test
    @DisplayName("When save duplicated and duplicated is null")
    public void test8(){

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(3,5,"1221"),
                        new Format(4,5,"1321")));

        Assertions.assertThatThrownBy(
                        () -> formatService.saveTransformToTxt(
                                Data_Provider.FILENAME_SAVE,SAVE, Type.DUPLICATED))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("T is null");
    }

    @Test
    @DisplayName("When save more than one duplicated and is correct format")
    @SneakyThrows
    public void test10() {

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(5, 5, "1221"),
                        new Format(5, 5, "1321"),
                        new Format(4, 5, "1321")));

        formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, SAVE, Type.DUPLICATED);

        try (var lines = Files.lines(Path.of(Data_Provider.FILENAME_SAVE))) {
            Assertions
                    .assertThat(lines.collect(Collectors.joining()))
                    .isEqualTo("1221,1321");
        }
    }

    @Test
    @DisplayName("When save one duplicated and is correct format")
    @SneakyThrows
    public void test11() {

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(5, 5, "1221"),

                        new Format(4, 5, "1321")));

        formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, SAVE, Type.DUPLICATED);

        try (var lines = Files.lines(Path.of(Data_Provider.FILENAME_SAVE))) {
            Assertions
                    .assertThat(lines.collect(Collectors.joining()))
                    .isEqualTo("1221");
        }
    }

    @Test
    @DisplayName("When save one transformed and is correct format")
    @SneakyThrows
    public void test12() {

        Mockito
                .when(formatRepository.getAll())
                .thenReturn(List.of(
                        new Format(3,5,"1221"),
                        new Format(5, 5, "1321"),
                        new Format(5, 5, "1321")));

        formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, SAVE, Type.TRANSFORMED);

        try (var lines = Files.lines(Path.of(Data_Provider.FILENAME_SAVE))) {
            Assertions
                    .assertThat(lines.collect(Collectors.joining()))
                    .isEqualTo("202");
        }
    }

        @Test
        @DisplayName("When save more than one transformed and is correct format")
        @SneakyThrows
        public void test13(){

            Mockito
                    .when(formatRepository.getAll())
                    .thenReturn(List.of(
                            new Format(3,5,"1221"),
                            new Format(4,5,"1321"),
                            new Format(5,5,"1321")));

            formatService.saveTransformToTxt(Data_Provider.FILENAME_SAVE, SAVE, Type.TRANSFORMED);

            try(var lines = Files.lines(Path.of(Data_Provider.FILENAME_SAVE))){
                Assertions
                        .assertThat(lines.collect(Collectors.joining()))
                        .isEqualTo("202,441");
            }
    }

    @AfterEach
    @SneakyThrows
    public void cleanData(){

        var path = Path.of(Data_Provider.FILENAME_SAVE);
        if(Files.exists(path)){
            Files.delete(path);
        }
    }
}
