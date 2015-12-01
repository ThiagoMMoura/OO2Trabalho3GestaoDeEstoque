package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.PessoaJuridica;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Douglas, Thiago
 */
public class PessoaJuridicaDAO {

    private static final String TABELA = "pessoa_juridica";
    private static final String COLUNAS
            = "cnpj, id_pessoa, nome_fantasia, inscricao_estadual";
    private static final String WHERE_ID = "where id = ?";

    private Connection conexao;
    private static PessoaJuridicaDAO objeto;

    private PessoaJuridicaDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
    }

    public static PessoaJuridicaDAO getInstance() throws SQLException {
        if (PessoaJuridicaDAO.objeto == null) {
            PessoaJuridicaDAO.objeto = new PessoaJuridicaDAO();
        }
        return PessoaJuridicaDAO.objeto;
    }

    private PessoaJuridica getPessoaFisicaByResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String cpf = resultSet.getString("cnpj");
        int idPessoa = resultSet.getInt("id_pessoa");
        String nomeFantasia = resultSet.getString("nome_fantasia");
        int inscricaoEstadual = resultSet.getInt("inscricao_estadual");

        return new PessoaJuridica(id, cpf, idPessoa, nomeFantasia, inscricaoEstadual);
    }

    public PessoaJuridica getPessoaJuridicaById(int id) throws SQLException {

        PreparedStatement stmt
                = this.conexao.prepareStatement(
                        "select " + COLUNAS
                        + " from " + TABELA + " "
                        + WHERE_ID);
        stmt.setInt(1, id);

        ResultSet retorno = stmt.executeQuery();
        PessoaJuridica pj = null;

        try {
            if (retorno.next()) {
                pj = this.getPessoaFisicaByResultSet(retorno);
            }
        } finally {
            retorno.close();
            stmt.close();
            return pj;
        }
    }

    public ArrayList<PessoaJuridica> getAll() throws SQLException {

        ArrayList<PessoaJuridica> listaPessoas = new ArrayList<>();

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

    public void save(PessoaJuridica pessoaJuridica) throws SQLException {

        PreparedStatement stmt;
        PessoaJuridica pj = this.getPessoaJuridicaById(pessoaJuridica.getId());

        if (pj == null) {
            stmt = conexao.prepareStatement(
                    "insert into " + TABELA
                    + " ( " + COLUNAS + ") "
                    + "values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, pessoaJuridica.getCnpj());
            stmt.setInt(2, pessoaJuridica.getIdPessoa());
            stmt.setString(3, pessoaJuridica.getNomeFantasia());
            stmt.setInt(4, pessoaJuridica.getInscricaoEstadual());
            stmt.executeUpdate();

            ResultSet retId = stmt.getGeneratedKeys();
            if (retId.next()) {
                int id = retId.getInt(1);
                pessoaJuridica.setId(id);
            }

            retId.close();
        } else {
            stmt = conexao.prepareStatement(
                    "update " + TABELA + " set "
                    + "cnpj = ?,"
                    + "id_pessoa = ?,"
                    + "nome_fantasia = ?,"
                    + "inscricao_estadual = ?"
                    + WHERE_ID);
            stmt.setString(1, pessoaJuridica.getCnpj());
            stmt.setInt(2, pessoaJuridica.getIdPessoa());
            stmt.setString(3, pessoaJuridica.getNomeFantasia());
            stmt.setInt(4, pessoaJuridica.getInscricaoEstadual());
            stmt.setInt(5, pessoaJuridica.getId());
            stmt.executeUpdate();
        }

        stmt.close();
    }
}
