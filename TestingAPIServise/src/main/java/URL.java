public enum URL {
    URL_API("http://users.bugred.ru/tasks/rest");

    public String url;

    URL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
