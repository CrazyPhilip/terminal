package com.crazyphilip.terminal.util;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class ReadPropertiesUtil {
    public static Properties getProperties(String propertiesPath){
        Properties properties = new Properties();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(propertiesPath));
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
