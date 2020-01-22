package mmtr.spring.dic.service;

import mmtr.spring.dic.repository.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Mservices implements IAction {

    @Override
    public List<String> showAllFromDic(String DicName){
        return ReadAllFromFile.readAllFromDic(DicName);
    }

    @Override
    public String searchByKey (String DicName, String Key) throws IOException {
        return SearchByKey.readFromFileByKey(DicName, Key);
    }

    @Override
    public String removeFromFile(String dicName, String key) throws IOException {
        return DeleteByKey.removeFromFileByKey(dicName, key);
    }

    @Override
    public String addValue(String filename, String key, String value) throws IOException {
        return AddValuesToFile.addToFileByKey(filename, key, value);
    }


}
