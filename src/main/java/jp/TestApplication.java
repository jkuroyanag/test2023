package jp;

import jp.service.ScrapeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TestApplication.class,args);

        final ScrapeService scrapeService = new ScrapeService();
        System.out.println(scrapeService.getTitle());
    }
}
