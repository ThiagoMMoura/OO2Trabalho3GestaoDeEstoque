package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.Contato;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Douglas, Thiago
 */
public class ContatoDAO {

    private static final String TABELA = "contato";
    private static final String COLUNAS = "id_pessoa, descricao, contato";
    private static final String WHERE_ID = "where id = ?";

    private Connection conexao;
    private static ContatoDAO objeto;

    private ContatoDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
    }

    public static ContatoDAO getInstance() throws SQLException {
        if (ContatoDAO.objeto == null) {
            ContatoDAO.objeto = new ContatoDAO();
        }
        return ContatoDAO.objeto;
    }

    private Contato getPessaByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        int idPessoa = resultSet.getInt("id_pessoa");
        String descricao = resultSet.getString("descricao");
        String contato = resultSet.getString("contato");

        return new Contato(idRet, idPessoa, descricao, contato);
    }

    public Contato getContatoById(int id) throws SQLException {

        PreparedStatement stmt = this.conexao.prepareStatement(
                "select id, " + COLUNAS + " from " + TABELA + " " + WHERE_ID);
        stmt.setInt(1, id);

        ResultSet retorno = stmt.executeQuery();
        Contato c = null;

        try {
            if (retorno.next()) {
                c = this.getPessaByResultSet(retorno);
            }
        } finally {
            retorno.close();
            stmt.close();
            return c;
        }
    }

    public ArrayList<Contato> getAll() throws SQLException {

        ArrayList<Contato> listaPessoas = new ArrayList<>();

        PreparedStatement stmt = conexao.prepareStatement(
                "select id, " + COLUNAS + " from " + TABELA);

        ResultSet retorno = stmt.executeQuery();
        while (retorno.next()) {
            listaPessoas.add(this.getPessaByResultSet(retorno));
        }

        retorno.close();
        stmt.close();
        return listaPessoas;
    }

    public void save(Contato contato) throws SQLException {

        PreparedStatement stmt;
        Contato c = this.getContatoById(contato.getId());

        if (c == null) {
            stmt = conexao.prepareStatement(
                    "insert into " + TABELA
                    + " ( " + COLUNAS + ") "
                    + "values (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, contato.getIdPessoa());
            stmt.setString(2, contato.getDescricao());
            stmt.setString(3, contato.getContato());
            stmt.executeUpdate();

            ResultSet retId = stmt.getGeneratedKeys();
            if (retId.next()) {
                int id = retId.getInt(1);
                contato.setId(id);
            }

            retId.close();
        } else {
            stmt = conexao.prepareStatement(
                    "update " + TABELA + " set "
                    + "id_pessoa = ?,"
                    + "descricao = ?,"
                    + "contato = ?"
                    + WHERE_ID);
            stmt.setInt(1, contato.getIdPessoa());
            stmt.setString(2, contato.getDescricao());
            stmt.setString(3, contato.getContato());
            stmt.setInt(4, contato.getId());
            stmt.executeUpdate();
        }

        stmt.close();
    }
}
