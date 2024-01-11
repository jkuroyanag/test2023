package jp.dao.dog;

import java.util.List;

public interface DogDao {

    List<DogDto> select(DogDtoSelector selector);

    int insert(Dog dog);

    int remove(DogDtoSelector selector);

    int update(DogDtoSelector selector);
}
