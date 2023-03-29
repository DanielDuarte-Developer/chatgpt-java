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
            String line = lines.get(i);
            String[] keyValue = line.split("=");
            result.put(keyValue[0],keyValue[1]);
        }
        return result;
    }
}
