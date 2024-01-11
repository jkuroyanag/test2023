package jp.dao.dog

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class dogDaoImplSTest_Select extends Specification {

    @Autowired
    DogDaoImpl dao

    def selector = new DogDtoSelector()

    def setup() {
        selector.ownerId = 101L // setupで設定した項目は全てのテストに適用される
    }

    @Ignore("insert関連で参照失敗するため一旦pending") //FIXME DBの初期化を行うように実装する
    def "全件取得 - 指定なし"() {
        given:
//        selector.dogId = [1L, 2L] 指定しない

        when:
        def actual = dao.select(selector)

        then:
        assert actual.size() == 2
        actual[0].with {
            assert dogId == 1L
            assert dogName == "moku"
            assert dogBreed == "pomeranian"
        }
        actual[1].with {
            assert dogId == 2L
            assert dogName == "mugi"
            assert dogBreed == "pekingese"
        }
    }

    def "1件指定"() {
        given:
        selector.dogId = [2L]

        when:
        def actual = dao.select(selector)

        then:
        assert actual.size() == 1
        actual[0].with {
            assert dogId == 2L
            assert dogName == "mugi"
            assert dogBreed == "pekingese"
        }
    }

    @Unroll
    // パラメタライズテストを行う際には@Unrollアノテーションを付与
    def "複数件取得 #testCase"() { // #の後にwhere区のパラメータを設定することでテスト名を動的に変化させることが出来る

        given: //spockSTestのみに反映される前提条件を記述
        selector.dogId = pDogId

        when: //テスト対象の振る舞いを記述、今回はdao層からselectメソッドを叩く
        def actual = dao.select(selector)

        then: // 上記のwhenで指定した振る舞いに対する結果をアサーション
        assert actual.size() == 1
        actual[0].with {
            assert dogId == eDogId
            assert dogName == eDogName
            assert dogBreed == eDogBreed
        }

        where: //ここでパラメタライズの設定を行う、今回は2テストパターンが実行される
        testCase             | pDogId || eDogId | eDogName | eDogBreed
        "ドッグIDが101の犬情報" | [1L]   || 1L     | "moku"   | "pomeranian"
        "ドッグIDが102の犬情報" | [2L]   || 2L     | "mugi"   | "pekingese"
    }
}
