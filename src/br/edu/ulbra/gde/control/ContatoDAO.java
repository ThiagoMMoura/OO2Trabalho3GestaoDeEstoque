package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.Contato;
import br.edu.ulbra.gde.model.DbModel;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public class ContatoDAO extends GenericDAO implements IDAO{

    protected static ContatoDAO objeto;

    private ContatoDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "contato";
        this.colunas = new String[]{"id_pessoa", "descricao", "contato"};
    }

    public static ContatoDAO getInstance() throws SQLException {
        if (ContatoDAO.objeto == null) {
            ContatoDAO.objeto = new ContatoDAO();
        }
        return ContatoDAO.objeto;
    }

    @Override
    public Contato getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        int idPessoa = resultSet.getInt(this.colunas[0]);
        String descricao = resultSet.getString(this.colunas[1]);
        String contato = resultSet.getString(this.colunas[2]);

        return new Contato(idRet, idPessoa, descricao, contato);
    }
    
    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id)
            throws SQLException {
        Contato contato = (Contato) dm;
        stmt.setInt(1, contato.getIdPessoa());
        stmt.setString(2, contato.getDescricao());
        stmt.setString(3, contato.getContato());
        if (id) {
            stmt.setInt(4, contato.getId());
        }
    }
 }
