package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.Endereco;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public class EnderecoDAO extends GenericDAO {

    protected static EnderecoDAO objeto;

    private EnderecoDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "endereco";
        this.colunas = new String[]{"cep", "logradouro", "bairro", "cidade", "uf"};
    }

    public static EnderecoDAO getInstance() throws SQLException {
        if (EnderecoDAO.objeto == null) {
            EnderecoDAO.objeto = new EnderecoDAO();
        }
        return EnderecoDAO.objeto;
    }

    @Override
    public Endereco getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        int cep = resultSet.getInt(this.colunas[0]);
        String logradouro = resultSet.getString(this.colunas[1]);
        String bairro = resultSet.getString(this.colunas[2]);
        String cidade = resultSet.getString(this.colunas[3]);
        String uf = resultSet.getString(this.colunas[4]);
        
        return new Endereco(cep, cep, logradouro, bairro, cidade, uf);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {
        Endereco contato = (Endereco) dm;
        stmt.setInt(1, contato.getCep());
        stmt.setString(2, contato.getLogradouro());
        stmt.setString(3, contato.getBairro());
        stmt.setString(4, contato.getCidade());
        stmt.setString(5, contato.getUf());
        if (id) {
            stmt.setInt(6, contato.getId());
        }
    }

}
