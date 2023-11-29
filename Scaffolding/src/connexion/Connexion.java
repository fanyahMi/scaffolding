/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import scaffolding.ConfigBase;

/**
 *
 * @author Fanyah
 */
public class Connexion {

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHote() {
        return hote;
    }

    public void setHote(String hote) {
        this.hote = hote;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    private String base;
    private String user;
    private String password;
    private String database;
    private String hote;
    private String port;
   
    
    public Connexion(ConfigBase config) {
        this.base = config.getServer();
        this.user = config.getUser();
        this.password = config.getPassword();
        this.database = config.getBase_name();
        this.hote = config.getHote();
        this.port = config.getPort();
    }
    
    
    public Connection getconnection() throws  Exception{
        Connection connexion;
        try {
            Class.forName(this.ClassforName());
            connexion = DriverManager.getConnection(this.DriverManager(), this.user, this.password);
            connexion.setAutoCommit(false);
            return connexion;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }

    
    private String ClassforName(){
        if("oracle".equals(this.base)){
            return "oracle.jdbc.driver.OracleDriver";
        }else if("postgresql".equals(this.base)){
            return "org.postgresql.Driver";
        }
        return null;
    }
     
    private String DriverManager(){
         if("oracle".equals(this.base)){
            return "jdbc:oracle:thin:@localhost:1521:"+this.database;
        }else if("postgresql".equals(this.base)){
            return "jdbc:postgresql://" + this.hote+ ":"+ this.port +"/"+this.database;
        }
        return null;
    }
   
    
    
}
