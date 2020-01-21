package mmtr.spring.dic.repository;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component("readFromFile")
public class ReadAllFromFile {
    private static String path;

    @Value("${pathToDic}")
    public void setPath(String path) {
        ReadAllFromFile.path = path;
    }

    public static String getPath() {
        return path;
    }

    public static List<String> readAllFromDic(String dicName) {
        File file = new File(getPath() + "//" + dicName);
        List<String> listResult = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                listResult.add(sc.nextLine());
            }
        }catch (Exception err){
            err.printStackTrace();
        }
        return listResult;
    }
}
