package fr.xebia.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The type File reader util.
 */
public class FileReaderUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReaderUtil.class);

    /**
     * Read string from file string.
     *
     * @param filePath the file path
     * @return the string
     */
    public static String readStringFromFile(String filePath) {
        InputStream is = FileReaderUtil.class.getResourceAsStream(filePath);
        return readFromInputStream(is);
    }

    private static String readFromInputStream(InputStream inputStream)
            {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return sb.toString();
    }
}
