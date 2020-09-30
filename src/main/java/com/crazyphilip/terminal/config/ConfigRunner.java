package com.crazyphilip.terminal.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

import static com.crazyphilip.terminal.TerminalApplication.Commands;

@Component
public class ConfigRunner implements ApplicationRunner {

    //@Value("classpath:static/json/commands.json")
    //private Resource areaRes;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        String jsonStr = "";
        try {
            Resource areaRes = new ClassPathResource("static/json/commands.json");
            //File jsonFile = areaRes.getFile();
            //FileReader fileReader = new FileReader(jsonFile);

            //Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            //int ch = 0;
            //StringBuffer sb = new StringBuffer();
            //while ((ch = reader.read()) != -1) {
            //    sb.append((char) ch);
            //}
            //fileReader.close();
            //reader.close();
            //jsonStr = sb.toString();

            BufferedReader br = new BufferedReader(new InputStreamReader(areaRes.getInputStream()));
            StringBuffer message = new StringBuffer();
            String line = null;
            while((line = br.readLine()) != null) {
                message.append(line);
            }
            jsonStr = message.toString();
            List<JSONObject> list = JSONObject.parseArray(jsonStr, JSONObject.class);

            list.forEach((item) -> {
                Commands.put(item.getString("name"), item.getString("output"));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
