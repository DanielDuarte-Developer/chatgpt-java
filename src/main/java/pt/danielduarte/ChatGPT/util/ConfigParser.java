package pt.danielduarte.ChatGPT.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigParser {
    //Map<Tipo_Dados_Index/Chave, Tipo_Dados_Valor>
    public static Map<String,String> parse(String filePath){
        Map<String,String> result = new HashMap<>();

        List<String> lines = FileUtils.readLines(filePath);

        for(int i = 0; i < lines.size(); i++){

            /*
            //1 - Way of getting hte value from application properties
            String line = lines.get(i);
            String[] keyValue = line.split("=");
            result.put(keyValue[0],keyValue[1]);

             */

            /*
            //2 - Way of getting hte value from application properties
            int splitPosition = line.indexOf("=");
            String key = line.substring(0,splitPosition);
            String value = line.substring(splitPosition + 1);

            result.put(key,value);

             */
        }
        return result;
    }
}
