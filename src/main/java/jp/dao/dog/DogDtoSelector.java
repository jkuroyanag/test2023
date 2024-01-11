package jp.dao.dog;

import lombok.Data;

import java.util.List;

@Data
public class DogDtoSelector {

    private Long ownerId;

    private List<Long> dogId;
    private List<String> dogName;
    private String dogBreed;
}
