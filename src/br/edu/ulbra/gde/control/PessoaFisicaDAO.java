package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.Data;
import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.PessoaFisica;
import java.sql.*;

/**
 *
 * @author Douglas
 */
public class PessoaFisicaDAO extends GenericDAO {

    private static PessoaFisicaDAO objeto;

    private PessoaFisicaDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "pessoa_fisica";
        this.colunas = new String[]{"cpf", "rg", "id_pessoa",
            "data_nascimento", "sexo"};
    }

    public static PessoaFisicaDAO getInstance() throws SQLException {
        if (PessoaFisicaDAO.objeto == null) {
            PessoaFisicaDAO.objeto = new PessoaFisicaDAO();
        }
        return PessoaFisicaDAO.objeto;
    }

    @Override
    public PessoaFisica getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String cpf = resultSet.getString(this.colunas[0]);
        String rg = resultSet.getString(this.colunas[1]);
        int idPessoa = resultSet.getInt(this.colunas[2]);
        java.util.Date dataNascimento = Data.parse(resultSet.getString(this.colunas[3]));
        char sexo = resultSet.getString(this.colunas[4]).charAt(0);

        return new PessoaFisica(id, cpf, rg, idPessoa, dataNascimento, sexo);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id)
            throws SQLException {
        PessoaFisica pessoaFisica = (PessoaFisica) dm;
        stmt.setString(1, pessoaFisica.getCpf());
        stmt.setString(2, pessoaFisica.getRg());
        stmt.setInt(3, pessoaFisica.getIdPessoa());
        stmt.setString(4, Data.formatToSQL(pessoaFisica.getDataNascimento()));
        stmt.setString(5, String.valueOf(pessoaFisica.getSexo()));
        if (id) {
            stmt.setInt(6, pessoaFisica.getId());
        }
    }
}
