/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaffolding;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.SQLException;
import util.ConfigBaseJson;

/**
 *
 * @author Fanyah
 */
public class Scaffolding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            String pathjson = "D:\\S5\\Naina\\Scaffolding\\src\\base.json";
            ConfigBaseJson json = new ConfigBaseJson(pathjson);
            Scaffold.generateclass(pathjson);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
