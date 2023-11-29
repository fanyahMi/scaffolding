/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaffolding;

import connexion.Connexion;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.soap.Detail;
import scaffolding.column.Column;
import scaffolding.detailclass.DetailClass;
import util.ConfigBaseJson;

/**
 *
 * @author Hasinjo
 */
public class Scaffold {
    private String language;
    private String packages;
    private String path;
    
    public static  void generateclass(String pathjson) throws SQLException, Exception{
        Connection c = null;
        try {
            ConfigBaseJson json = new ConfigBaseJson(pathjson);
            ConfigBase config = json.getConfig();
            Connexion connexion = new Connexion(config);
            c = connexion.getconnection();
            Scaffold st = new Scaffold();
            st.setPackages(config.getPackage_name());
            st.setLanguage(config.getLanguage());
            st.setPath(config.getPath_generate());
            st.generate(c);
        } catch (Exception e) {
           throw  e;
        }finally{
            if(c != null) c.close();
        }
    }
  
    private void generate(Connection connexion) throws Exception{
        List<DetailClass> list_class = new ArrayList<>();
        try {
            String[] tab = getTables(connexion);
            DetailClass detail = null;
            for (String string : tab) {
                detail = new DetailClass(packages, string, language);
                detail.setList_columns( getColumn(connexion, string) );
                list_class.add(detail);
            }
            generate_class(list_class);
        } catch (Exception e) {
            throw  e;
        }
    }
    
    public void generate_class(List<DetailClass> list_class) throws Exception{
        try {
            for (DetailClass list_clas : list_class) {
                createFile(getTemplate(list_clas), list_clas);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private String getTemplate(DetailClass class_g) throws IOException{
        String repository_tamplate = "";
        if(language.equals("java")){
           repository_tamplate =  util.Utility.getDirectorieProject()+"\\src\\tamplate\\java"; 
        }
        else if(language.equals("csharp")){
            repository_tamplate =  util.Utility.getDirectorieProject()+"\\src\\tamplate\\csharp"; 
        }
        String contenu = new String(Files.readAllBytes(Paths.get(repository_tamplate))); 
        contenu = contenu.replace("##classname##", class_g.getClassname());
        contenu = contenu.replace("##import##", class_g.getImportCode());
        contenu = contenu.replace("##package##", class_g.getPackages());
        contenu = contenu.replace("##attributs##", class_g.getAttributsCode());
        contenu = contenu.replace("##getterssetters##", class_g.getGettersSettersCode());
        return contenu;
    }
    
    private void createFile(String contenue, DetailClass class_r) throws Exception{
         try {
            File dossier = new File(path+"\\"+packages);
            if (!dossier.exists()) {
                dossier.mkdirs();
            }
            String cheminFichier = "";
            if(language.equals("java")){
              cheminFichier  = path+"\\"+packages+"\\"+class_r.getClassname()+".java";
            }else{
                cheminFichier  = path+"\\"+packages+"\\"+class_r.getClassname()+".cs";
            }          
            Path path = Paths.get(cheminFichier);
            Files.write(path, Arrays.asList(contenue), StandardOpenOption.CREATE);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public Column[] getColumn(Connection connexion, String table) throws SQLException, Exception{
        String sql = "SELECT * FROM "+table;
        PreparedStatement statement = connexion.prepareStatement(sql);
        try {
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            Column[] rep =  new Column[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rep[i-1] = new Column(metaData.getColumnName(i),metaData.getColumnTypeName(i),language);
            }
            return rep;
           
        } catch (Exception e) {
            throw e;
        }finally{
            if(statement != null){
                statement.close();
            }
        }
    } 
    
    private String[] getTables(Connection connexion) throws Exception{
        try {
            DatabaseMetaData metaData = connexion.getMetaData();
            String schema = connexion.getSchema();
            ResultSet tables = metaData.getTables(null, schema, null, new String[]{"TABLE"});
            ArrayList<String> tableNamesList = new ArrayList<>();
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                tableNamesList.add(tableName);
            }
            return tableNamesList.toArray(new String[0]);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public Scaffold(String language) {
        this.language = language;
    }

    public Scaffold() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
