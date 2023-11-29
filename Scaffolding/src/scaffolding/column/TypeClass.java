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
public class TypeClass {
    private String name_class;
    private String package_attribuite;

    public TypeClass(String name_class, String package_attribuite) {
        this.name_class = name_class;
        this.package_attribuite = package_attribuite;
    }

    
    public TypeClass() {
    }

   
    public String getPackage_attribuite() {
        return package_attribuite;
    }

    public void setPackage_attribuite(String package_attribuite) {
        this.package_attribuite = package_attribuite;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }
    
}
