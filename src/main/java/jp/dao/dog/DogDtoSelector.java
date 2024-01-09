package jp.dao.dog;

import lombok.Data;

@Data
public class DogDtoSelector {

    private Long ownerId;

    private Long dogId;
    private String dogName;
    private String dogBreed;
}
