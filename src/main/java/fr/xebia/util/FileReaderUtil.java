package fr.xebia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReaderUtil {

    public String readStringFromFile(String filePath) throws IOException{
        Class clazz = this.getClass();
        InputStream is = clazz.getResourceAsStream(filePath);
        return readFromInputStream(is);
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }
}
