package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.ItemPedido;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public class ItemPedidoDAO extends GenericDAO {

    protected static ItemPedidoDAO objeto;

    private ItemPedidoDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "item_pedido";
        this.colunas = new String[]{"id_pedido", "id_produto", "quantidade", "custo"};
    }

    public static ItemPedidoDAO getInstance() throws SQLException {
        if (ItemPedidoDAO.objeto == null) {
            ItemPedidoDAO.objeto = new ItemPedidoDAO();
        }
        return ItemPedidoDAO.objeto;
    }

    @Override
    public ItemPedido getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        int idPedido = resultSet.getInt(this.colunas[0]);
        int idProduto = resultSet.getInt(this.colunas[1]);
        int quantidade = resultSet.getInt(this.colunas[2]);
        float custo = resultSet.getFloat(this.colunas[3]);

        return new ItemPedido(idRet, idPedido, idProduto, quantidade, custo);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {
        ItemPedido item = (ItemPedido) dm;
        stmt.setInt(1, item.getIdPedido());
        stmt.setInt(2, item.getIdProduto());
        stmt.setInt(3, item.getQuantidade());
        stmt.setFloat(4, item.getCusto());
        if (id) {
            stmt.setInt(5, item.getId());
        }
    }

}
