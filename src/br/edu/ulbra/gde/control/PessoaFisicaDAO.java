package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.PessoaFisica;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
public class PessoaFisicaDAO {

    private static final String TABELA = "pessoa_fisica";
    private static final String COLUNAS
            = "cpf, rg, id_pessoa, data_nascimento, sexo";
    private static final String WHERE_ID = "where id = ?";
    
    private Connection conexao;
    private static PessoaFisicaDAO objeto;

    private PessoaFisicaDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
    }

    public static PessoaFisicaDAO getInstance() throws SQLException {
        if (PessoaFisicaDAO.objeto == null) {
            PessoaFisicaDAO.objeto = new PessoaFisicaDAO();
        }
        return PessoaFisicaDAO.objeto;
    }

    private PessoaFisica getPessoaFisicaByResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String cpf = resultSet.getString("cpf");
        String rg = resultSet.getString("rg");
        int idPessoa = resultSet.getInt("id_pessoa");
        Date dataNascimento = Date.valueOf(resultSet.getString("data_nascimento"));
        char sexo = resultSet.getString("sexo").charAt(0);

        return new PessoaFisica(id, cpf, rg, idPessoa, dataNascimento, sexo);
    }

    public PessoaFisica getPessoaFisicaById(int id) throws SQLException {

        PreparedStatement stmt
                = this.conexao.prepareStatement(
                        "select " + COLUNAS
                        + " from " + TABELA + " "
                        + WHERE_ID);
        stmt.setInt(1, id);

        ResultSet retorno = stmt.executeQuery();
        PessoaFisica pf = null;

        try {
            if (retorno.next()) {
                pf = this.getPessoaFisicaByResultSet(retorno);
            }
        } finally {
            retorno.close();
            stmt.close();
            return pf;
        }
    }

    public ArrayList<PessoaFisica> getAll() throws SQLException {

        ArrayList<PessoaFisica> listaPessoas = new ArrayList<>();

        PreparedStatement stmt = conexao.prepareStatement(
                "select id, " + COLUNAS + " from " + TABELA);

        ResultSet retorno = stmt.executeQuery();
        while (retorno.next()) {
            listaPessoas.add(this.getPessoaFisicaByResultSet(retorno));
        }

        retorno.close();
        stmt.close();
        return listaPessoas;
    }

    public void save(PessoaFisica pessoaFisica) throws SQLException {

        PreparedStatement stmt;
        PessoaFisica d = this.getPessoaFisicaById(pessoaFisica.getId());

        if (d == null) {
            stmt = conexao.prepareStatement(
                    "insert into " + TABELA
                    + " ( " + COLUNAS + ") "
                    + "values (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, pessoaFisica.getCpf());
            stmt.setString(2, pessoaFisica.getRg());
            stmt.setInt(3, pessoaFisica.getIdPessoa());
            stmt.setString(4, pessoaFisica.getDataNascimento().toString());
            stmt.setString(5, String.valueOf(pessoaFisica.getSexo()));
            stmt.executeUpdate();

            ResultSet retId = stmt.getGeneratedKeys();
            if (retId.next()) {
                int id = retId.getInt(1);
                pessoaFisica.setId(id);
            }

            retId.close();
        } else {
            stmt = conexao.prepareStatement(
                    "update " + TABELA + " set "
                    + "cpf = ?,"
                    + "rg = ?,"
                    + "id_pessoa = ?,"
                    + "data_nascimento = ?,"
                    + "sexo = ?"
                    + WHERE_ID);
            stmt.setString(1, pessoaFisica.getCpf());
            stmt.setString(2, pessoaFisica.getRg());
            stmt.setInt(3, pessoaFisica.getIdPessoa());
            stmt.setString(4, pessoaFisica.getDataNascimento().toString());
            stmt.setString(5, String.valueOf(pessoaFisica.getSexo()));
            stmt.setInt(6, pessoaFisica.getId());
            stmt.executeUpdate();
        }

        stmt.close();
    }
}
