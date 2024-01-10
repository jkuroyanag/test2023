package jp.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@EnableAutoConfiguration
@ComponentScan
public class DbTest {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public void method() {
        // プレースホルダ
        SqlParameterSource param = new MapSqlParameterSource().addValue("p", 2);
        String name = jdbc.queryForObject("SELECT COUNT(*) FROM TBL_CUSTOMER WHERE ID=:p", param, String.class);

        System.out.println("count = " + name);
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(DbTest.class, args)) {
            DbTest m = ctx.getBean(DbTest.class);
            m.method();
        }
    }
}
