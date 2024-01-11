package jp.dao.dog

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class dogDaoImplSTest_Remove extends Specification {

    @Autowired
    DogDaoImpl dao

    def selectDog = new DogDtoSelector()

    //手動insert
    def insertDog = new Dog()

    def setup() {
        selectDog.dogId = [3L]

        //手動insert
        insertDog.dogId = 3L
        insertDog.dogName = "siba"
        insertDog.dogBreed = "sibainu"
    }

    //FIXME DBが初期化されないため仮実装になっている
    def "1件削除"() {
        given:

        when:
        //手動insert
        def insertActual = dao.insert(insertDog)
        //手動select
        def actual = dao.select(selectDog)
        //remove実行
        def actualSize = dao.remove(selectDog)
        //remove -> 削除確認
        def eActual = dao.select(selectDog)

        then:
        assert actualSize == 1
        assert eActual.size() == 0
        assert actual.size() == 1
        actual[0].with {
            assert dogId == 3L
            assert dogName == "siba"
            assert dogBreed == "sibainu"
        }
    }
}
