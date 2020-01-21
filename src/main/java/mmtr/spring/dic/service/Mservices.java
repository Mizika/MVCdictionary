package mmtr.spring.dic.service;

import mmtr.spring.dic.repository.IAction;
import mmtr.spring.dic.repository.ReadAllFromFile;
import mmtr.spring.dic.repository.SearchByKey;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Mservices implements IAction {

    public List<String> showAllFromDic(String DicName){
        return ReadAllFromFile.readAllFromDic(DicName);
    }

    public String searchByKey (String DicName, String Key) throws IOException {
        return SearchByKey.readFromFileByKey(DicName, Key);
    }

}
