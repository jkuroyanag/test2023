package jp.dao.dog

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class dogDaoImplSTest extends Specification {

    @Autowired
    DogDaoImpl dao

    def selector = new DogDtoSelector()

    def setup() {
        selector.ownerId = 101L // setupで設定した項目は全てのテストに適用される
    }

    @Unroll
    // パラメタライズテストを行う際には@Unrollアノテーションを付与
    def "複数件取得 #testCase"() { // #の後にwhere区のパラメータを設定することでテスト名を動的に変化させることが出来る

        given: //spockSTestのみに反映される前提条件を記述
        selector.dogId = pDogId

        when: //テスト対象の振る舞いを記述、今回はdao層からselectメソッドを叩く
        def actual = dao.select(selector)

        then: // 上記のwhenで指定した振る舞いに対する結果をアサーション
        assert actual.size() == 2
        actual[pSize].with {
            assert dogId == eDogId
            assert dogName == eDogName
            assert dogBreed == eDogBreed
        }

        where: //ここでパラメタライズの設定を行う、今回は2テストパターンが実行される
        testCase             | pSize | pDogId || eDogId | eDogName | eDogBreed
        "ドッグIDが101の犬情報" | 0     | 1L     || 1L     | "moku"   | "pomeranian"
        "ドッグIDが102の犬情報" | 1     | 2L     || 2L     | "mugi"   | "pekingese"
    }
}

