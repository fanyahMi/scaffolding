/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import scaffolding.ConfigBase;

/**
 *
 * @author Fanyah
 */
public class ConfigBaseJson {
    private String file;

    public ConfigBaseJson(String filename) {
        this.file = filename;
    }
    
    public ConfigBase getConfig() throws Exception{
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Gson gson = new Gson();
            ConfigBase config = gson.fromJson(reader, ConfigBase.class);
            return config;
        } catch (Exception e) {
            throw  e;
        }
    }
}
