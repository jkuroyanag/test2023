package jp;

import jp.service.ScrapeService;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//mybatis-spring-boot-starterは@Mapperを自動的に読み込むため不要らしい->@Mapper付与してないけど動いているなあ
//https://reasonable-code.com/spring-boot-mapperscan/
//@MapperScan(basePackages = "src/main/java/jp/dao", annotationClass = Mapper.class)
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TestApplication.class,args);

        final ScrapeService scrapeService = new ScrapeService();
        System.out.println(scrapeService.getTitle());
    }
}
