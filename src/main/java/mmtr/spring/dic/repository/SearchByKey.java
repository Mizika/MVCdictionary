package mmtr.spring.dic.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Component("searchByKey")
public class SearchByKey {
    private static String path;

    @Value("${pathToDic}")
    public void setPath(String path) {
        SearchByKey.path = path;
    }

    public static String getPath() {
        return path;
    }

    private static BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

    public static String readFromFileByKey(String dicName, String key) throws IOException {

        Map<String, String> data = DictionaryReader.readerFromFile(getPath(), dicName);
        return data.getOrDefault(key, "NOT FOUND");
    }
}