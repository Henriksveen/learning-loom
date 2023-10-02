package common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileInput {

    public String read(String fileName) {
        try {
            return Files.readString(new File("advent2022/src/main/resources/%s".formatted(fileName)).toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
