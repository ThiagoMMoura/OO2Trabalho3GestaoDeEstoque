package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.Data;
import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.Pedido;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public class PedidoDAO extends GenericDAO {

    protected static PedidoDAO objeto;

    private PedidoDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "pedido";
        this.colunas = new String[]{"cnpj", "data", "observacao", "descricao"};
    }

    public static PedidoDAO getInstance() throws SQLException {
        if (PedidoDAO.objeto == null) {
            PedidoDAO.objeto = new PedidoDAO();
        }
        return PedidoDAO.objeto;
    }

    @Override
    public Pedido getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        String cnpj = resultSet.getString(this.colunas[0]);
        java.util.Date data = Data.parse(resultSet.getString(this.colunas[1]));
        String observacao = resultSet.getString(this.colunas[2]);
        String descricao = resultSet.getString(this.colunas[3]);

        return new Pedido(idRet, cnpj, data, observacao, descricao);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {
        Pedido pedido = (Pedido) dm;
        stmt.setString(1, pedido.getCnpj());
        stmt.setString(2, Data.formatToSQL(pedido.getData()));
        stmt.setString(3, pedido.getObservacao());
        stmt.setString(4, pedido.getDescricao());
        if (id) {
            stmt.setInt(5, pedido.getId());
        }
    }

}
