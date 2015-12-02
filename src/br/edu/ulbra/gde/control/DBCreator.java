package br.edu.ulbra.gde.control;

import java.io.*;
import java.sql.*;

/**
 *
 * @author Douglas
 */
public class DBCreator {

    public static void criarTabelas(Connection conexao) {
        System.out.println(DBAdapter.class.getSimpleName()
                + " - Criando tabelas do Banco de Dados...");
        try {
            File script = new File("create_script.sql");
            if (script.exists()) {
                FileReader fileReader = new FileReader(script);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                StringBuilder sb = new StringBuilder();
                while (bufferedReader.ready()) {
                    sb.append(bufferedReader.readLine());
                }
                
                String[] sqls = sb.toString().split(";");
                Statement stmt = conexao.createStatement();
                for (String sql : sqls) {
                    stmt.execute(sql);
                }
            } else {
                System.err.println("Arquivo \"create_script.sql\" não encontrado!");
            }

        } catch (SQLException | IOException ex) {
            System.err.println("Erro na criação de tabelas: " + ex.getMessage());
        }
    }
}
