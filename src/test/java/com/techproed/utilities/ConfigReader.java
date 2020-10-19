package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Bu clas'in amaci, configration properties dosyasindaki test datalarini(verilerini) okumaktir.
    //creat Properties instance
    private static Properties properties;
    //FileInputStream kullanarak bir dosya aciyoruz
    //Properties'i bu dosyaya yukluyoruz
    //Dha sonra Properties dosyasini okuyacagiz

    //Baslatmak icin static block olusturduk
    static {
        String path="configuration.properties";
        try {
            FileInputStream file=new FileInputStream(path);
            properties=new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //okumak cin static bir method olusturalim.
    //Bu method kullanici anahtar kelimeyi girdiginde value return eder.
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
