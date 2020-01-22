package mmtr.spring.dic.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

@Component("deleteByKey")
public class DeleteByKey {
    private static String path;

    @Value("${pathToDic}")
    public void setPath(String path) {
        DeleteByKey.path = path;
    }

    public static String getPath() {
        return path;
    }

    public static String removeFromFileByKey(String dicName, String key) throws IOException {
        Map<String, String> data = DictionaryReader.readerFromFile(getPath(), dicName);

        if (data.get(key) != null) {
                FileWriter fstream = new FileWriter(path+"//"+dicName);
                BufferedWriter out = new BufferedWriter(fstream);
                String value = data.get(key);
                data.remove(key);
                for (Map.Entry entry : data.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
                return "Значение \"" +" "+key+" "+value + "\" было удалено!";
        }else {
                return "NOT_FOUND";
            }
    }
    }
