package net.voids.installer;

public enum Value {

    JAR_URL("THE JAR URL"),
    JSON_URL("The JSON URL");

    public String url;
    Value(String url) {
        this.url = url;
    }
}
