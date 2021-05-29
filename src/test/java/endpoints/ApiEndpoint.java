package endpoints;

public enum ApiEndpoint {
    BOOKS("/Books"),
    BOOK("/Book");

    private final String path;

    ApiEndpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
