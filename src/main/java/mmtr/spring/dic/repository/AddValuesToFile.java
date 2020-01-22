package mmtr.spring.dic.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("addValuesToFile")
public class AddValuesToFile {
    private static String path;

    @Value("${pathToDic}")
    public void setPath(String path) {
        AddValuesToFile.path = path;
    }

    public static String getPath() {
        return path;
    }

    private static Pattern number = Pattern.compile("\\d{5}");
    private static Pattern letters = Pattern.compile("\\D{4}");
    private static Matcher fileReg;

    public static String addToFileByKey(String filename, String key, String value) throws IOException {
        Map<String, String> data = DictionaryReader.readerFromFile(getPath(), filename);

        if (data.get(key) == null) {
            if (filename.equals("second.txt")) {
                fileReg = number.matcher(value);
            }
            else if (filename.equals("first.txt")) {
                fileReg = letters.matcher(value);
            }
            if (fileReg.matches()) {
                FileWriter fstream = new FileWriter(getPath() + "//" + filename);
                BufferedWriter out = new BufferedWriter(fstream);
                data.put(key, value);

                for (Map.Entry entry : data.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
                return "Значение \"" + key + " " + value + "\" было добавленно!";
            } else { return "Введено не корректное значение!"; }
        }else { return "Значение с данным ключом уже создано!"; }
    }
}
