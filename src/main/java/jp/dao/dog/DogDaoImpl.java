package jp.dao.dog;

import jp.dao.MyBatisDaoBase;
import jp.dao.dog.mapper.DogMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogDaoImpl extends MyBatisDaoBase implements DogDao {

    protected DogDaoImpl(SqlSessionTemplate sqlSession){
        super(sqlSession);
    }

    @Override
    public List<DogDto> select(DogDtoSelector selector){
        return this.getSqlSession().getMapper(DogMapper.class).select(selector);
    }
}
