package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlParser {

    public static YamlFile getYamlFile(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        YamlFile file = null;
        try {
            file = mapper.readValue(new File("src/main/resources/info.yaml"), YamlFile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
