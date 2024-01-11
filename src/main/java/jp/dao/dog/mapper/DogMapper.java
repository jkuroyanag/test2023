package jp.dao.dog.mapper;

import jp.dao.dog.Dog;
import jp.dao.dog.DogDto;
import jp.dao.dog.DogDtoSelector;

import java.util.List;

public interface DogMapper {

    List<DogDto> select(DogDtoSelector selector);

    int insert(Dog dog);
}
