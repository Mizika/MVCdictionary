package mmtr.spring.dic.service;

import mmtr.spring.dic.repository.DeleteByKey;
import mmtr.spring.dic.repository.IAction;
import mmtr.spring.dic.repository.ReadAllFromFile;
import mmtr.spring.dic.repository.SearchByKey;
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


}
