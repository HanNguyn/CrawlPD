package models;

public enum UrlType {
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