package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.Pessoa;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Thiago Moura, Douglas Angeli
 */
public class PessoaDAO {

    private static final String TABELA = "pessoa";
    private static final String COLUNAS
            = "razao_social, id_endereco, numero_endereco, complemento_endereco";
    private static final String WHERE_ID = "where id = ?";
    private static final String CREATE
            = "CREATE TABLE " + TABELA + " ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "razao_social TEXT,"
            + "id_endereco INTEGER,"
            + "numero_endereco INTEGER,"
            + "complemento_endereco TEXT )";

    private Connection conexao;
    private static PessoaDAO objeto;

    private PessoaDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        try {
            this.create();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        };
    }

    public static PessoaDAO getInstance() throws SQLException {
        if (PessoaDAO.objeto == null) {
            PessoaDAO.objeto = new PessoaDAO();
        }
        return PessoaDAO.objeto;
    }

    public void create() throws SQLException {
        PreparedStatement stmt = this.conexao.prepareStatement(CREATE);
        boolean execute = stmt.execute();
    }

    private Pessoa getPessaByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        String razaoSocial = resultSet.getString("razao_social");
        int idEndereco = resultSet.getInt("id_endereco");
        int numeroEndereco = resultSet.getInt("numero_endereco");
        String complementoEndereco = resultSet.getString("complemento_endereco");

        return new Pessoa(idRet, razaoSocial, idEndereco, numeroEndereco, complementoEndereco);
    }

    public Pessoa getPessoaById(int id) throws SQLException {

        PreparedStatement stmt
                = this.conexao.prepareStatement(
                        "select id, " + COLUNAS
                        + " from " + TABELA + " "
                        + WHERE_ID);
        stmt.setInt(1, id);

        ResultSet retorno = stmt.executeQuery();
        Pessoa p = null;

        try {
            if (retorno.next()) {
                p = this.getPessaByResultSet(retorno);
            }
        } finally {
            retorno.close();
            stmt.close();
            return p;
        }
    }

    public ArrayList<Pessoa> getAll() throws SQLException {

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

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

    public void save(Pessoa pessoa) throws SQLException {

        PreparedStatement stmt;
        Pessoa d = this.getPessoaById(pessoa.getId());

        if (d == null) {
            stmt = conexao.prepareStatement(
                    "insert into " + TABELA
                    + " ( " + COLUNAS + ") "
                    + "values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, pessoa.getRazaoSocial());
            stmt.setInt(2, pessoa.getIdEndereco());
            stmt.setInt(3, pessoa.getNumeroEndereco());
            stmt.setString(4, pessoa.getComplementoEndereco());
            stmt.executeUpdate();

            ResultSet retId = stmt.getGeneratedKeys();
            if (retId.next()) {
                int id = retId.getInt(1);
                pessoa.setId(id);
            }

            retId.close();
        } else {
            stmt = conexao.prepareStatement(
                    "update " + TABELA + " set "
                    + "razao_social = ?,"
                    + "id_endereco = ?,"
                    + "numero_endereco = ?,"
                    + "complemento_endereco = ?"
                    + WHERE_ID);
            stmt.setString(1, pessoa.getRazaoSocial());
            stmt.setInt(2, pessoa.getIdEndereco());
            stmt.setInt(3, pessoa.getNumeroEndereco());
            stmt.setString(4, pessoa.getComplementoEndereco());
            stmt.setInt(5, pessoa.getId());
            stmt.executeUpdate();
        }        

        stmt.close();
    }
}
