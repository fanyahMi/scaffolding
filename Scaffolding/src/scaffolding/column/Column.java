/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaffolding.column;

/**
 *
 * @author Niaina
 */
public class Column {
    private String namecolumn;
    private TypeClass type_column;
    
    public Column(String namecolumn, String type, String language) throws Exception {
        this.namecolumn = namecolumn;
        setType_column( GenerateType.generateType(namecolumn, type, language) );
    }
    
    
    
    
    public String getNamecolumn() {
        return namecolumn;
    }

    public void setNamecolumn(String namecolumn) {
        this.namecolumn = namecolumn;
    }

    public TypeClass getType_column() {
        return type_column;
    }

    public void setType_column(TypeClass type_column) {
        this.type_column = type_column;
    }

    

    public Column() {
    }
    
   
}
