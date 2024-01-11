package jp.dao.dog

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class dogDaoImplSTest_Insert extends Specification {

    @Autowired
    DogDaoImpl dao

    def insertDog = new Dog()
    def selectDog = new DogDtoSelector()

    def setup() {
        insertDog.dogId = 3L
        insertDog.dogName = "siba"
        insertDog.dogBreed = "sibainu"

        selectDog.dogId = [3L]
    }

    def "1件登録"() {
        given:

        when:
        def actualSize = dao.insert(insertDog)
        def actual = dao.select(selectDog)
        //手動削除
//        def remove = dao.remove(selectDog)

        then:
        assert actualSize == 1
        assert actual.size() == 1
        actual[0].with {
            assert dogId == 3L
            assert dogName == "siba"
            assert dogBreed == "sibainu"
        }
    }
}
