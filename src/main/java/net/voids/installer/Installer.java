package net.voids.installer;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Installer {

    public final File directory = new File(System.getenv("APPDATA") + "/.minecraft/versions/Test");
    public final File jar = new File(directory, "Test.jar");
    public final File json = new File(directory, "Test.json");

    public Installer setup() throws IOException {
        if (!directory.exists()) directory.mkdirs();
        if (!jar.exists()) jar.createNewFile();
        if (!json.exists()) json.createNewFile();
        return new Installer();
    }

    public Installer finish() throws IOException {
        FileUtils.copyURLToFile(new URL(Value.JAR_URL.url), jar);
        FileUtils.copyURLToFile(new URL(Value.JSON_URL.url), json);
        return new Installer();
    }



    public static void main(String[] args) throws IOException {
        Installer installer = new Installer().setup().finish();
    }

}