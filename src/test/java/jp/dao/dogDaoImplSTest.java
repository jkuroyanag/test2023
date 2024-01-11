package jp.dao;

import jp.dao.dog.DogDaoImpl;
import jp.dao.dog.DogDto;
import jp.dao.dog.DogDtoSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class dogDaoImplSTest {

    @Autowired
    DogDaoImpl dao;

    @DisplayName("全件取得 - 指定なし")
    @Test
    void select_all_dog() {
        final DogDtoSelector selector = new DogDtoSelector();
//        selector.setDogId(List.of(1L)); 指定しない

        final List<DogDto> actual = dao.select(selector);

        assertEquals(2, actual.size());
        assertAll(
                () -> assertEquals(1L, actual.get(0).getDogId()),
                () -> assertEquals("moku", actual.get(0).getDogName()),
                () -> assertEquals("pomeranian", actual.get(0).getDogBreed()),
                () -> assertEquals(2L, actual.get(1).getDogId()),
                () -> assertEquals("mugi", actual.get(1).getDogName()),
                () -> assertEquals("pekingese", actual.get(1).getDogBreed())
        );
    }

    @DisplayName("1件指定")
    @Test
    void select_one_dog() {
        final DogDtoSelector selector = new DogDtoSelector();
        selector.setDogId(List.of(1L));

        final List<DogDto> actual = dao.select(selector);

        assertEquals(1, actual.size());
        assertAll(
                () -> assertEquals(1L, actual.get(0).getDogId()),
                () -> assertEquals("moku", actual.get(0).getDogName()),
                () -> assertEquals("pomeranian", actual.get(0).getDogBreed())
        );
    }

    static Stream<Arguments> parameterized_method() {
        return Stream.of(
                arguments(1L, 1L, "moku", "pomeranian"),
                arguments(2L, 2L, "mugi", "pekingese")
        );
    }

    @DisplayName("複数件取得")
    @ParameterizedTest //パラメーター化テストに付与
    @MethodSource("parameterized_method")
        //様々な型を渡すことができる、上記でメソッドを作成する必要がある
    void select_parameterized_dog(Long pDogId, Long eDogId, String eDogName, String EDogBreed) { //メソッド内で渡すための変数宣言
        final DogDtoSelector selector = new DogDtoSelector();
        selector.setDogId(List.of(pDogId));

        final List<DogDto> actual = dao.select(selector);

        assertEquals(1, actual.size());
        assertAll(
                () -> assertEquals(eDogId, actual.get(0).getDogId()),
                () -> assertEquals(eDogName, actual.get(0).getDogName()),
                () -> assertEquals(EDogBreed, actual.get(0).getDogBreed())
        );
    }
}
