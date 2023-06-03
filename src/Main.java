import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    final static String BASE_URL = "https://wallpaper.mob.org/";


    public static void main(String[] args) {
        //https://wallpaper.mob.org/

//        UrlType.TAG.toString();
        int page;
//        String urlType = UrlType.BEST.toString().replace("{page}", String.valueOf(page));
//        System.out.println(urlType);

        Set<String> urls = new HashSet<>();
//        List<String> urls = new ArrayList<>();


        for (page = 1; page <= 10; page++) {
            String urlType = UrlType.BEST.toString().replace("{page}", String.valueOf(page));
            System.out.println("--------------------\nSTART CRAWL PAGE " + page);
            Document doc1;

            String fullPath = BASE_URL + urlType;
            System.out.println(fullPath);
            try {
                doc1 = Jsoup.connect(fullPath).get();
                Elements elements = doc1.select("#page-images-gallery > div.image-gallery__items.image-gallery-items-container > div > ul > li");
                for (Element element : elements) {
                    Element aTag = element.selectFirst("div > a");
                    String href;

                    if (aTag != null) {
                        href = aTag.attr("href");
                        urls.add(href);
                        System.out.println("href=" + href);
                    }
                }

            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
            }
            System.out.println("END CRAWL PAGE " + page);
        }
//*****************************************************************************
//        for (String url: urls) {
//            String fullPath = BASE_URL + url;
//            System.out.println("fullPath = " + fullPath);
//            try {
//                Document doc = Jsoup.connect(fullPath).get();
//
//                Element containerElement = doc.selectFirst("");
////            System.out.println(element.html());
//                if (containerElement != null) {
//                    Elements elements = containerElement.select("a");
//                    for (Element element : elements) {
//                        String href = element.attr("href");
//                        String title = element.attr("title");
//                        String size = element.text();
//                        System.out.println("title = " + title);
//                        System.out.println("href = " + href);
//                        System.out.println("size = " + size);
//                    }
//                }
//
//            } catch (IOException e) {
//                System.err.println(e.getLocalizedMessage());
//            }
//        }

    }

    enum UrlType {
        /**
         * lấy Type thuộc về TAG của URL.
         * <p>
         * //@page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
         * //@tag: Được định nghĩa là tag mà mình cần thay thế sau khi sử dụng
         */
        TAG("gallery/tag={tag}/{page}/"),
        /**
         * lấy Type thuộc về COLOR của URL.
         * <p>
         * //@page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
         * //@tag: Được định nghĩa là tag mà mình cần thay thế sau khi sử dụng
         */
        COLOR("gallery/color={tag}/{page}/"),
        /**
         * lấy Type thuộc về BEST của URL.
         * <p>
         * //@page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
         */
        BEST("best/{page}/");

        private final String text;

        UrlType(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
