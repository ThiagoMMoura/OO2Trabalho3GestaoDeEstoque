package br.edu.ulbra.gde.control;

import java.sql.*;

public class DBAdapter {

    public static final String urlConnection = "jdbc:sqlite:gde.db";
    private static Connection conexao;

    private static DBAdapter objeto;

    private DBAdapter() throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
    }

    public static Connection getConnection() throws SQLException {

        if (DBAdapter.objeto == null) {
            DBAdapter.objeto = new DBAdapter();
        }

        if (DBAdapter.conexao == null) {
            DBAdapter.conexao = DriverManager.getConnection(urlConnection);
        }
        return DBAdapter.conexao;
    }

    public static void close() throws SQLException {
        DBAdapter.conexao.close();
    }

}
