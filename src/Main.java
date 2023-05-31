import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    final static String BASE_URL = "https://wallpaper.mob.org/";

    enum UrlType {
        /**
         * lấy Type thuộc về TAG của URL.
         *
         * @page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
         * @tag: Được định nghĩa là tag mà mình cần thay thế sau khi sử dụng
         */
        TAG("gallery/tag={tag}/{page}/"),
        /**
         * lấy Type thuộc về COLOR của URL.
         *
         * @page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
         * @tag: Được định nghĩa là tag mà mình cần thay thế sau khi sử dụng
         */
        COLOR("gallery/color={tag}/{page}/"),
        /**
         * lấy Type thuộc về BEST của URL.
         *
         * @page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
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

    public static void main(String[] args) {
        //https://wallpaper.mob.org/

        UrlType.TAG.toString();
        int page = 10;
        String urlType = UrlType.BEST.toString().replace("{page}", String.valueOf(page));
        System.out.println(urlType);

        try {
            Document doc = Jsoup.connect(BASE_URL).get();
            Document doc1 = Jsoup.connect(BASE_URL).get();
            System.out.println(doc.html());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
