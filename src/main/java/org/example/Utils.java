package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final int INVALID_CSV_FILE_TOKEN_ERROR_CODE = 1;
    public static final int MISSING_CSV_FILE = 2;

    public static List<Book> loadLibrary(Path path) {
        List<Book> library = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                library.add(loadBook(line));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("%d | Arquivo CSV com os dados da biblioteca não foi encontrado.", MISSING_CSV_FILE));
        }
        return library;
    }

    static Book loadBook(String line) {
        final String[] tokens = line.split(",");
        return new Book(getToken(tokens, 0), Integer.parseInt(getToken(tokens, 1)), Genre.valueOf(getToken(tokens, 2)),
                Year.parse(getToken(tokens, 3)), getToken(tokens, 4));
    }

    static String getToken(String[] tokens, int idx) {
        final String token = tokens[idx];
        if (token == null) {
            throw new IllegalArgumentException(String.format("%d | Token inválido encontrado no index i:%d.", INVALID_CSV_FILE_TOKEN_ERROR_CODE, idx));
        }
        return token.trim();
    }
}