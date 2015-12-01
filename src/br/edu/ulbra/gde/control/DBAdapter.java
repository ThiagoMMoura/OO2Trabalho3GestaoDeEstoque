package br.edu.ulbra.gde.control;

import java.io.File;
import java.sql.*;

public class DBAdapter {

    public static final String urlConnection = "jdbc:sqlite:gde.db";
    private static Connection conexao;

    private static DBAdapter objeto;

    private DBAdapter() throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
    }

    public static Connection getConnection() throws SQLException {

        boolean exists = true;

        if (DBAdapter.objeto == null) {
            exists = new File("gde.db").exists();
            DBAdapter.objeto = new DBAdapter();
        }

        if (DBAdapter.conexao == null) {
            DBAdapter.conexao = DriverManager.getConnection(urlConnection);
        }

        if (!exists) {
            DBAdapter.criarTabelas();
        }

        return DBAdapter.conexao;
    }

    public static void close() throws SQLException {
        DBAdapter.conexao.close();
    }

    private static void criarTabelas() {
        System.out.println(DBAdapter.class.getSimpleName()
                + " - Criando tabelas do Banco de Dados...");
        try {
            System.out.println("pessoa");
            PessoaDAO.getInstance().create();

            System.out.println("pessoa_fisica");
            PessoaFisicaDAO.getInstance().create();
        } catch (SQLException ex) {
            System.err.println("Erro na criação de tabelas: " + ex.getMessage());
        }
    }
}
