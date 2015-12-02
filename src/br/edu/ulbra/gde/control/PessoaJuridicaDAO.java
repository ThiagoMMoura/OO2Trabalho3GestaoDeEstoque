package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.PessoaJuridica;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public class PessoaJuridicaDAO extends GenericDAO implements IDAO{

    private static PessoaJuridicaDAO objeto;

    private PessoaJuridicaDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "pessoa_juridica";
        this.colunas = new String[]{"cnpj", "id_pessoa",
            "nome_fantasia", "inscricao_estadual"};
    }

    public static PessoaJuridicaDAO getInstance() throws SQLException {
        if (PessoaJuridicaDAO.objeto == null) {
            PessoaJuridicaDAO.objeto = new PessoaJuridicaDAO();
        }
        return PessoaJuridicaDAO.objeto;
    }

    @Override
    public PessoaJuridica getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String cpf = resultSet.getString(this.colunas[0]);
        int idPessoa = resultSet.getInt(this.colunas[1]);
        String nomeFantasia = resultSet.getString(this.colunas[2]);
        int inscricaoEstadual = resultSet.getInt(this.colunas[3]);

        return new PessoaJuridica(id, cpf, idPessoa, nomeFantasia, inscricaoEstadual);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {
        PessoaJuridica pessoaJuridica = (PessoaJuridica) dm;
        stmt.setString(1, pessoaJuridica.getCnpj());
        stmt.setInt(2, pessoaJuridica.getIdPessoa());
        stmt.setString(3, pessoaJuridica.getNomeFantasia());
        stmt.setInt(4, pessoaJuridica.getInscricaoEstadual());
        if (id) {
            stmt.setInt(5, pessoaJuridica.getId());
        }
    }
}
