/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaffolding.detailclass;

import scaffolding.column.Column;

/**
 *
 * @author Niaina
 */
public class DetailClass {
    private String packages;
    private String classname;
    private String language;
    private Column[] list_columns;

    
    
    public String getGettersSettersCode(){
        StringBuilder gettersSettersCode = new StringBuilder();
        if(language.compareTo("java")==0){
            for (Column column : this.getList_columns()) {
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    public ").append(column.getType_column().getName_class()).append(" get").append(util.Utility.capitalize(column.getNamecolumn())).append("() {");
                gettersSettersCode.append("\n");
                gettersSettersCode.append("        return ").append(column.getNamecolumn()).append(";");
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    }");

                // Ajouter le code du setter
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    public void set").append(util.Utility.capitalize(column.getNamecolumn())).append("(").append(column.getType_column().getName_class()).append(" ").append(column.getNamecolumn()).append(") {");
                gettersSettersCode.append("\n");
                gettersSettersCode.append("        this.").append(column.getNamecolumn()).append(" = ").append(column.getNamecolumn()).append(";");
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    }");
            }
        }
        else if(language.compareTo("csharp")==0){
            for (Column column : this.getList_columns()) {
                // Ajouter le code du getter
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    public ").append(column.getType_column().getName_class()).append(" get").append(util.Utility.capitalize(column.getNamecolumn())).append("() {");
                gettersSettersCode.append("\n");
                
                gettersSettersCode.append("        return ").append(column.getNamecolumn()).append(";");
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    }");

                // Ajouter le code du setter
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    public void set").append(util.Utility.capitalize(column.getNamecolumn())).append("(").append(column.getType_column().getName_class()).append(" ").append(column.getNamecolumn()).append(") {");
                gettersSettersCode.append("\n");
                gettersSettersCode.append("        this.").append(column.getNamecolumn()).append(" = ").append(column.getNamecolumn()).append(";");
                gettersSettersCode.append("\n");
                gettersSettersCode.append("    }");
            }
        }
        return gettersSettersCode.toString();
    }
    

    
    public String getAttributsCode(){
        StringBuilder attributsCode = new StringBuilder();
        for (Column column : this.getList_columns()) {
            attributsCode.append("\n");
            attributsCode.append("  private "+column.getType_column().getName_class()+" "+column.getNamecolumn()).append(";");
        }
        return attributsCode.toString();
    }
    
    public String getImportCode(){
        StringBuilder code = new StringBuilder();
        if(language.compareTo("java")==0){
            for (Column column : this.getList_columns()) {
                if (!column.getType_column().getPackage_attribuite().equals("java.lang")) {
                    code.append("import ").append(column.getType_column().getPackage_attribuite()).append("."+column.getType_column().getName_class()+";\n");
                }
            }
        }
        else if(language.compareTo("csharp")==0){
            for (Column column : this.getList_columns()) {
                if (!column.getType_column().getPackage_attribuite().equals("System")) {
                    code.append("using ").append(column.getType_column().getName_class()).append(";\n");
                }   
            }
        }
        return code.toString();
    }

    public DetailClass(String packages, String classname, String language) {
        this.packages = packages;
        this.classname = classname;
        this.language = language;
    }
    
    

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    
   

    public DetailClass() {
    }
    
    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getClassname() {
        return util.Utility.capitalize(classname);
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Column[] getList_columns() {
        return list_columns;
    }

    public void setList_columns(Column[] list_columns) {
        this.list_columns = list_columns;
    }
    
}
