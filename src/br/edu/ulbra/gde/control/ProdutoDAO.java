package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.Produto;
import java.sql.*;

/**
 *
 * @author Thiago Moura, Douglas Angeli
 */
public class ProdutoDAO extends GenericDAO {

    protected static ProdutoDAO objeto;

    private ProdutoDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "produto";
        this.colunas = new String[]{"ref", "ref_fornecedor", "descricao",
            "valor", "lucro", "quantidade", "unidade", "ativo"};
    }

    public static ProdutoDAO getInstance() throws SQLException {
        if (ProdutoDAO.objeto == null) {
            ProdutoDAO.objeto = new ProdutoDAO();
        }
        return ProdutoDAO.objeto;
    }

    @Override
    public Produto getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String ref = resultSet.getString(this.colunas[0]);
        String refFornecedor = resultSet.getString(this.colunas[1]);
        String descricao = resultSet.getString(this.colunas[2]);
        float preco = resultSet.getFloat(this.colunas[3]);
        float lucro = resultSet.getFloat(this.colunas[4]);
        int quantidade = resultSet.getInt(this.colunas[5]);
        String unidade = resultSet.getString(this.colunas[6]);
        boolean ativo = resultSet.getInt(this.colunas[7]) == 1;

        return new Produto(id, ref, refFornecedor, descricao,
                preco, lucro, quantidade, unidade, ativo);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {

        Produto produto = (Produto) dm;

        stmt.setString(1, produto.getRef());
        stmt.setString(2, produto.getRefFornecedor());
        stmt.setString(3, produto.getDescricao());
        stmt.setFloat(4, produto.getPreco());
        stmt.setFloat(5, produto.getLucro());
        stmt.setInt(6, produto.getQuantidade());
        stmt.setString(7, produto.getUnidade());
        stmt.setInt(8, produto.isAtivo() ? 1 : 0);
        if (id) {
            stmt.setInt(9, produto.getId());
        }
    }

}
