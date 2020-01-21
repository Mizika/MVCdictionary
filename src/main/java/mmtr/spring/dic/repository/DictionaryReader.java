package mmtr.spring.dic.repository;


import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component("dictionaryReader")
public class DictionaryReader {

    private static Map<String, String> hashMap;

    public static  Map<String, String> readerFromFile(String filePath, String dicName) {
        hashMap = new HashMap<>();
        File file=new File(filePath + "//" + dicName);
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = readFromFile.readLine())!= null){
                String[] tmp = line.split(" ");
                hashMap.put(tmp[0], tmp[1]);
            }
            return hashMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
