package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.Telefone;
import java.sql.*;

/**
 *
 * @author Douglas
 */
public class TelefoneDAO extends GenericDAO {

    protected static TelefoneDAO objeto;

    private TelefoneDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "telefone";
        this.colunas = new String[]{"id_pessoa", "ddd", "telefone", "descricao", "principal"};
    }

    public static TelefoneDAO getInstance() throws SQLException {
        if (TelefoneDAO.objeto == null) {
            TelefoneDAO.objeto = new TelefoneDAO();
        }
        return TelefoneDAO.objeto;
    }

    @Override
    public Telefone getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idPessoa = resultSet.getInt(this.colunas[0]);
        int ddd = resultSet.getInt(this.colunas[1]);
        String telefone = resultSet.getString(this.colunas[2]);
        String descricao = resultSet.getString(this.colunas[3]);
        boolean principal = resultSet.getInt(this.colunas[4]) == 1;

        return new Telefone(id, idPessoa, ddd, telefone, descricao, principal);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {
        Telefone telefone = (Telefone) dm;

        stmt.setInt(1, telefone.getIdPessoa());
        stmt.setInt(2, telefone.getDdd());
        stmt.setString(3, telefone.getTelefone());
        stmt.setString(4, telefone.getDescricao());
        stmt.setInt(5, telefone.isPrincipal() ? 1 : 0);
        if (id) {
            stmt.setInt(6, telefone.getId());
        }
    }

}
