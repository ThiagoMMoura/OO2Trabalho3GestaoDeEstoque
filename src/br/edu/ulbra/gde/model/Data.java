/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ulbra.gde.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adiministrador
 */
public class Data {

    public static String format(Date data) {
        return data==null?"":DateFormat.getDateInstance().format(data);
    }

    public static String formatToSQL(Date data) {
        String[] s = format(data).split("/");
        return s[2] + "-" + s[1] + "-" + s[0];
    }

    public static Date parse(String target) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(target);
        } catch (ParseException ex) {
            return null;
        }
    }
}
