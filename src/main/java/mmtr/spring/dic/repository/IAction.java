package mmtr.spring.dic.repository;

import java.io.IOException;
import java.util.List;

public interface IAction {
    List<String> showAllFromDic(String dictionaryName);

    String searchByKey(String DicName, String Key) throws IOException;
}
