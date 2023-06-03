public class Main {
    public static void main(String[] args) {
        new Crawl().start();
    }


//    final static String BASE_URL = "https://wallpaper.mob.org/";
//
//
//    public static void main(String[] args) {
//        //https://wallpaper.mob.org/
//
////        UrlType.TAG.toString();
//        int page;
////        String urlType = UrlType.BEST.toString().replace("{page}", String.valueOf(page));
////        System.out.println(urlType);
//
//        Set<String> urls = new HashSet<>();
////        List<String> urls = new ArrayList<>();
//
//
//        for (page = 1; page <= 3; page++) {
//            String urlType = UrlType.BEST.toString().replace("{page}", String.valueOf(page));
////            String urlType = UrlType.TAG.toString()
////                    .replace("{page}", String.valueOf(page))
////                    .replace("{tag}", String.valueOf("abstract"));
//            System.out.println("--------------------\nSTART CRAWL PAGE " + page);
//            Document doc1;
//
//            String fullPath = BASE_URL + urlType;
//            System.out.println(fullPath);
//            try {
//                doc1 = Jsoup.connect(fullPath).get();
//                Elements elements = doc1.select("#page-images-gallery > div.image-gallery__items.image-gallery-items-container > div > ul > li");
//                for (Element element : elements) {
//                    Element imgTag = element.selectFirst("div > a > img");
//                    Elements hiddenTags = element.select("div > ul > li");
//
//                    if (imgTag != null) {
//                        String imgSrc = imgTag.attr("src");
//                        if (imgSrc.isEmpty()) {
//                            imgSrc = imgTag.attr("data-src");
//                        }
//
//                        System.out.println("Link = " + imgSrc);
//
//                        System.out.print("TAG: ");
//                        for (Element hiddenTag: hiddenTags) {
//                            Element aTag = hiddenTag.selectFirst("a");
//                            if (aTag != null) {
//                                System.out.println(aTag.text());
//                            }
//                        }
//                        System.out.println("------------------------------------------------------------");
//                    }
//                }
//
//            } catch (IOException e) {
//                System.err.println(e.getLocalizedMessage());
//            }
//            System.out.println("END CRAWL PAGE " + page);
//        }
//    }
//
//    enum UrlType {
//        /**
//         * lấy Type thuộc về TAG của URL.
//         * <p>
//         * //@page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
//         * //@tag: Được định nghĩa là tag mà mình cần thay thế sau khi sử dụng
//         */
//        TAG("gallery/tag={tag}/{page}/"),
//        /**
//         * lấy Type thuộc về COLOR của URL.
//         * <p>
//         * //@page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
//         * //@tag: Được định nghĩa là tag mà mình cần thay thế sau khi sử dụng
//         */
//        COLOR("gallery/color={tag}/{page}/"),
//        /**
//         * lấy Type thuộc về BEST của URL.
//         * <p>
//         * //@page: Được định nghĩa là trang mình cần thay thế sau khi sử dụng
//         */
//        BEST("best/{page}/");
//
//        private final String text;
//
//        UrlType(final String text) {
//            this.text = text;
//        }
//
//        @Override
//        public String toString() {
//            return text;
//        }
//    }
}
