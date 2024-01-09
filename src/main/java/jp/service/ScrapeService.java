package jp.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScrapeService {
    private String url = "https://qiita.com/jkuroyanag/items/d9f770da989b0f100955";

    public String getTitle() throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements title = document.select("title");
        return title.text();
    }
}
