import models.UrlType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

class Crawl {
    final static String BASE_URL = "https://wallpaper.mob.org/";

    Document connect(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    Map<String, List<String>> fetchData(Document document) {
        Map<String, List<String>> results = new HashMap<>();
        Elements elements = document.select("#page-images-gallery > div.image-gallery__items.image-gallery-items-container > div > ul > li");
        for (Element element : elements) {
            Element imgTag = element.selectFirst("div > a > img");
            Elements hiddenTags = element.select("div > ul > li");

            // imageUrl: String, tags: List<String>
            if (imgTag != null) {
                String imgSrc = imgTag.attr("src");
                if (imgSrc.isEmpty()) {
                    imgSrc = imgTag.attr("data-src");
                }
//                System.out.println("Link = " + imgSrc);

                List<String> tags = new ArrayList<>();
//                System.out.print("TAG: ");
                for (Element hiddenTag : hiddenTags) {
                    Element aTag = hiddenTag.selectFirst("a");
                    if (aTag != null) {
                        tags.add(aTag.text());
//                        System.out.println(aTag.text());
                    }
                }

                results.put(imgSrc, tags);
//                System.out.println("------------------------------------------------------------");
            }
        }

        return results;
    }

    void runWith(int page) {
        String urlType = UrlType.BEST.toString().replace("{page}", String.valueOf(page));
        System.out.println("--------------------\nSTART CRAWL PAGE " + page);

        String fullPath = BASE_URL + urlType;
        System.out.println(fullPath);
        try {
            Document document = connect(fullPath);
            Map<String, List<String>> results = fetchData(document);

        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println("END CRAWL PAGE " + page);
    }


    void start() {
        for (int page = 1; page <= 3; page++) {
            runWith(page);
        }
    }


}
