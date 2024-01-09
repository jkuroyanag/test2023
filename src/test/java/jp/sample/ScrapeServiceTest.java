package jp.sample;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrapeServiceTest {

    @Test
    public void getTitle() throws IOException {
        final ScrapeService scrapeService = new ScrapeService();
        assertEquals("Spockまとめ（基本的な使い方） #テスト - Qiita", scrapeService.getTitle());
    }
}