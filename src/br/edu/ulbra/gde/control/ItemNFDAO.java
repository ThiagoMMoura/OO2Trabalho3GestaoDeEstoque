package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.ItemNF;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public class ItemNFDAO extends GenericDAO {

    protected static ItemNFDAO objeto;

    private ItemNFDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "item_nf";
        this.colunas = new String[]{"id_nf", "id_produto", "quantidade", "custo"};
    }

    public static ItemNFDAO getInstance() throws SQLException {
        if (ItemNFDAO.objeto == null) {
            ItemNFDAO.objeto = new ItemNFDAO();
        }
        return ItemNFDAO.objeto;
    }

    @Override
    public ItemNF getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        int idNF = resultSet.getInt(this.colunas[0]);
        int idProduto = resultSet.getInt(this.colunas[1]);
        int quantidade = resultSet.getInt(this.colunas[2]);
        float custo = resultSet.getFloat(this.colunas[3]);

        return new ItemNF(idNF, idNF, idProduto, quantidade, custo);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {
        ItemNF item = (ItemNF) dm;
        stmt.setInt(1, item.getIdNF());
        stmt.setInt(2, item.getIdProduto());
        stmt.setInt(3, item.getQuantidade());
        stmt.setFloat(4, item.getCusto());
        if (id) {
            stmt.setInt(5, item.getId());
        }
    }

}
