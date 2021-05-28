public enum UrlLink {
    URL_LOGIN_PAGE("https://www.goodreads.com/"), URL_BOOK_PAGE("https://www.goodreads.com/book/show/");
    private String urlAddress;

    UrlLink(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getUrlAddress() {
        return urlAddress;
    }
}
