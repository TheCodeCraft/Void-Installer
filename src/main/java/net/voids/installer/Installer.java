package net.voids.installer;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Installer {

    private final File directory = new File(System.getenv("APPDATA") + "/.minecraft/versions/Test");
    private final File jar = new File(directory, "Test.jar");
    private final File json = new File(directory, "Test.json");

    private Installer setup() throws IOException {
        if (!directory.exists()) directory.mkdirs();
        if (!jar.exists()) jar.createNewFile();
        if (!json.exists()) json.createNewFile();
        return new Installer();
    }

    private Installer finish() throws IOException {
        FileUtils.copyURLToFile(new URL(Value.JAR_URL.url), jar);
        FileUtils.copyURLToFile(new URL(Value.JSON_URL.url), json);
        return new Installer();
    }

    public static void main(String[] args) throws IOException {
        new Installer().setup().finish();
    }
}
