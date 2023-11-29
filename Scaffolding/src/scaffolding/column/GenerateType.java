/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaffolding.column;

import util.Utility;

/**
 *
 * @author Niaina
 */
public class GenerateType {
    public static TypeClass generateType(String name_column ,String type, String language) throws Exception{
        TypeClass response = new TypeClass();
        try {
            if(language.compareTo("java")==0){ 
                return generateJava(type);
            }else if(language.compareTo("csharp")==0){
                return generateCsharp(type);
            }else{
                throw  new Exception("Il faut mettre le type de language");
            }
            
        } catch (Exception e) {
            throw new Exception("impossible de voir le type de ce column "+name_column);
        }
    }
    
    public static TypeClass generateJava(String type) throws Exception{
        String name_class = "";
        String package_attribuite = "";
        boolean check  = false;
        if ("varchar".equals(type) ||
            "text".equals(type) ||
            "json".equals(type) ||
            "char".equals(type) ||
            "uuid".equals(type)) {
            name_class = "String";
            package_attribuite = "java.lang";
            check = true;
        } else if ("int".equals(type) || Utility.chercheMotCle(type, "int") != null ) {
            name_class = "Integer";
            package_attribuite = "java.lang";
            check = true;
        } else if ("bigint".equals(type) ||
                   "serial".equals(type)) {
            name_class = "Long";
            package_attribuite = "java.lang";
            check = true;
        } else if ("numeric".equals(type) ||
                   "decimal".equals(type) ||
                   "double".equals(type)) {
            name_class = "Double";
            package_attribuite = "java.lang";
            check = true;
        } else if ("real".equals(type)) {
            name_class = "Float";
            package_attribuite = "java.lang";
            check = true;
        } else if ("date".equals(type)) {
            name_class = "Date";
            package_attribuite = "java.sql";
            check = true;
        } else if ("time".equals(type)) {
            name_class = "Time";
            package_attribuite = "java.sql";
            check = true;
        } else if ("timestamp".equals(type)) {
            name_class = "Timestamp";
            package_attribuite = "java.sql";
            check = true;
        } else if ("boolean".equals(type)) {
            name_class = "Boolean";
            package_attribuite = "java.lang";
            check = true;
        } else {
            name_class = "Object";
            package_attribuite = "java.lang";
            check = true;
        }
        
        if(check == false) throw  new Exception();
        return new  TypeClass(name_class, package_attribuite); 
    }
    
    public static  TypeClass generateCsharp(String type) throws Exception{
        String name_class = "";
        String package_attribuite = "";
        boolean check = false;
        type = type.toLowerCase();
        
        if ("varchar".equals(type) || "text".equals(type) || "json".equals(type) || "char".equals(type) || "uuid".equals(type)) {
            name_class = "string";
            package_attribuite = "System";
            check = true;
        } else if ("int".equals(type)) {
            name_class = "int";
            package_attribuite = "System";
            check = true;
        } else if ("bigint".equals(type) || "serial".equals(type)) {
            name_class = "long";
            package_attribuite = "System";
            check = true;
        } else if ("numeric".equals(type) || "decimal".equals(type) || "double".equals(type)) {
            name_class = "double";
            package_attribuite = "System";
        } else if ("real".equals(type)) {
            name_class = "float";
            package_attribuite = "System";
            check = true;
        } else if ("date".equals(type)) {
            name_class = "DateTime";
            package_attribuite = "System";
            check = true;
        } else if ("time".equals(type)) {
            name_class = "TimeSpan";
            package_attribuite = "System";
            check = true;
        } else if ("timestamp".equals(type)) {
            name_class = "DateTime";
            package_attribuite = "System";
            check = true;
        } else if ("boolean".equals(type)) {
            name_class = "bool";
            package_attribuite = "System";
            check = true;
        } else {
            name_class = "object";
            package_attribuite = "System";
            check = true;
        }

        
        if(check == false) throw  new Exception();
        return new  TypeClass(name_class, package_attribuite); 
    }

    
}