/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ulbra.gde.model;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Adiministrador
 */
public class Data {
    
    public static String format(Date data){
        return DateFormat.getDateInstance().format(data);
    }
    
    public static String formatToSQL(Date data){
        String[] s = format(data).split("/");
        return s[2]+"-"+s[1]+"-"+s[0];
    }
}
