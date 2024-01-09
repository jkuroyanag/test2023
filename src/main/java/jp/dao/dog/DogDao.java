package jp.dao.dog;

import java.util.List;

public interface DogDao {

    List<DogDto> select(DogDtoSelector selector);
}
