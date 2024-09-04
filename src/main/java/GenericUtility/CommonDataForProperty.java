package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonDataForProperty {

    public  String  readCommonData(String key) throws IOException {
        String path="./src/test/resources/commondata1.property";
        FileInputStream fid=new FileInputStream(path);

        Properties prop=new Properties();
        prop.load(fid);

     return  prop.getProperty(key);
    }
}
