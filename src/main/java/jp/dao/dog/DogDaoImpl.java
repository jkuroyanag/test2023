package jp.dao.dog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DogDaoImpl implements DogDao {

    public List<DogDto> select(DogDtoSelector selector){
        DogDto dto1 = new DogDto();
        dto1.setDogId(1L);
        dto1.setDogName("moku");
        dto1.setDogBreed("pomeranian");

        DogDto dto2 = new DogDto();
        dto2.setDogId(2L);
        dto2.setDogName("mugi");
        dto2.setDogBreed("pekingese");

        List<DogDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);
        return dtos;
    }
}
