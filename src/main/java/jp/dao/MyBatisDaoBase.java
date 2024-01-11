package jp.dao;

import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;

public abstract class MyBatisDaoBase implements InitializingBean {
    protected final SqlSessionTemplate sqlSession;

    protected MyBatisDaoBase(SqlSessionTemplate sqlSession){
        this.sqlSession = sqlSession;
    }

    protected SqlSession getSqlSession(){
        return this.sqlSession;
    }

    public void afterPropertiesSet(){
        this.sqlSession.getConfiguration().setLocalCacheScope(LocalCacheScope.STATEMENT);
    }
}
