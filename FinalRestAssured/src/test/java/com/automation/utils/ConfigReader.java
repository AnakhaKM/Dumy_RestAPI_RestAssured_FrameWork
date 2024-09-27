package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //The properties class maintain key-value pairs
    static Properties prop;

    public static void initConfig() {

        //This prepares the prop object to hold the properties from the configuration file.
        prop = new Properties();
        try {
            //reads the file. The load method reads the key-value pairs and stores them in prop object.
            prop.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //takes a String key as an argument.
    public static String getConfigValue(String key) {
        //return the value associated with the provided key from the loaded properties.
        return prop.getProperty(key);
    }
    public static void setConfigValue(String key,String value)  {
        prop.setProperty(key,value);
        try {
            prop.save(new FileOutputStream("src/test/resources/config/config.properties"),"sucess");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}