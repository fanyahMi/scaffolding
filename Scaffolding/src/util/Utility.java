/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fanyah
 */

public class Utility {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static String getDirectorieProject(){
        return System.getProperty("user.dir");
    }
    
    public static  String chercheMotCle(String texte, String motCle) {
        // Utilisation d'une expression régulière pour rechercher le mot-clé
        String motif = ".*?\\b(" + Pattern.quote(motCle) + "\\d*).*";
        Pattern pattern = Pattern.compile(motif, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texte);

        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
