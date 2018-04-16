package com.qatest.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlOprions {

    public static YamlFile read() {
        YamlFile yamlFile = null;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            yamlFile = objectMapper.readValue(new File("src/main/resources/config.yaml"), YamlFile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return yamlFile;
    }

}
