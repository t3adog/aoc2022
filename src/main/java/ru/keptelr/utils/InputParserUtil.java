package ru.keptelr.utils;

import lombok.SneakyThrows;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class InputParserUtil {

    private InputParserUtil() {

    }

    @SneakyThrows
    public static List<String> readFile(String day) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(day + ".txt");
        Path path = Path.of(Objects.requireNonNull(url).toURI());
        return Files.readAllLines(path, Charset.defaultCharset());
    }
}
