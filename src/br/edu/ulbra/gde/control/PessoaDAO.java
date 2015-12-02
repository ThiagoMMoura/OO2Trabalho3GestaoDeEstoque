package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.Pessoa;
import java.sql.*;

/**
 *
 * @author Thiago Moura, Douglas Angeli
 */
public class PessoaDAO extends GenericDAO implements IDAO{

    private static PessoaDAO objeto;

    private PessoaDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "pessoa";
        this.colunas = new String[]{"razao_social", "id_endereco",
            "numero_endereco", "complemento_endereco"};
    }

    public static PessoaDAO getInstance() throws SQLException {
        if (PessoaDAO.objeto == null) {
            PessoaDAO.objeto = new PessoaDAO();
        }
        return PessoaDAO.objeto;
    }

    @Override
    public Pessoa getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        String razaoSocial = resultSet.getString(this.colunas[0]);
        int idEndereco = resultSet.getInt(this.colunas[1]);
        int numeroEndereco = resultSet.getInt(this.colunas[2]);
        String complementoEndereco = resultSet.getString(this.colunas[3]);

        return new Pessoa(idRet, razaoSocial, idEndereco, numeroEndereco, complementoEndereco);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id)
            throws SQLException {
        Pessoa pessoa = (Pessoa) dm;
        stmt.setString(1, pessoa.getRazaoSocial());
        stmt.setInt(2, pessoa.getIdEndereco());
        stmt.setInt(3, pessoa.getNumeroEndereco());
        stmt.setString(4, pessoa.getComplementoEndereco());
        if (id) {
            stmt.setInt(5, pessoa.getId());
        }
    }
}
