package jp.dao.dog

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class dogDaoImplSTest_Update extends Specification {

    @Autowired
    DogDaoImpl dao

    def selector = new DogDtoSelector()

    def "1件変更"() {
        given:
        selector.dogId = [3L]
        selector.dogName = ["inu"]
        selector.dogBreed = "sibainu"

        when:
        def updateActual = dao.update(selector)
        //手動select
        def actual = dao.select(new DogDtoSelector(dogId: List.of(3L)))

        then:
        assert updateActual == 1
        assert actual.size() == 1
        actual[0].with {
            assert dogId == 3L
            assert dogName == "inu"
            assert dogBreed == "sibainu"
        }
    }
}
