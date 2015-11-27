package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.Pessoa;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Thiago Moura, Douglas Angeli
 */
public class PessoaDAO {

    private Connection conexao;

    // Utiliza modelo Singleton
    private static PessoaDAO objeto;

    private PessoaDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
    }

    public static PessoaDAO getInstance() throws SQLException {
        if (PessoaDAO.objeto == null) {
            PessoaDAO.objeto = new PessoaDAO();
        }
        return PessoaDAO.objeto;
    }

    public Pessoa getPessoaById(int id) throws SQLException {
        // Cria o objeto para consulta
        PreparedStatement stmt = conexao.prepareStatement("select * from pessoa where id = ?");

        // Monta a consulta
        stmt.setInt(1, id);
        ResultSet retorno = stmt.executeQuery();

        if (retorno.next()) {
            int idRet = retorno.getInt("id");
            String razaoSocial = retorno.getString("razao_social");
            int idEndereco = retorno.getInt("id_endereco");
            int numeroEndereco = retorno.getInt("numero_endereco");
            String complementoEndereco = retorno.getString("complemento_endereco");

            Pessoa p = new Pessoa(idRet, razaoSocial, idEndereco, numeroEndereco, complementoEndereco);
            return (p);
        }

        retorno.close();
        stmt.close();
        return null;
    }

    public ArrayList<Pessoa> getAll() throws SQLException {
        // Cria o objeto para consulta
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("select * from pessoa");
        ResultSet retorno = stmt.executeQuery();

        while (retorno.next()) {
            int id = retorno.getInt("id");
            listaPessoas.add(this.getPessoaById(id));
        }
        retorno.close();
        stmt.close();
        return listaPessoas;
    }

    public void save(Pessoa pessoa) throws SQLException {

        PreparedStatement stmt;

        // Verifica se a pessoa existe
        Pessoa d = this.getPessoaById(pessoa.getId());
        if (d == null) {
            // Cria o objeto para insercao
            stmt = conexao.prepareStatement(
                    "insert into pessoa (razao_social,id_endereco,numero_endereco,complemento_endereco) "
                    + "values (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.getRazao_social());
            stmt.setInt(2, pessoa.getId_endereco());
            stmt.setInt(3, pessoa.getNumero_endereco());
            stmt.setString(4, pessoa.getComplemento_endereco());
            stmt.executeUpdate();

            ResultSet retId = stmt.getGeneratedKeys();
            if (retId.next()) {
                int id = retId.getInt(1);
                pessoa.setId(id);
            }

            retId.close();
            stmt.close();
        } else {
            // Pessoa ja existe, altera o nome
            // Cria o objeto para insercao
            stmt = conexao.prepareStatement(
                    "update pessoa set razao_social = ? where id = ?");
            stmt.setString(1, pessoa.getRazao_social());
            stmt.setInt(2, pessoa.getId());
            stmt.executeUpdate();

            stmt.close();
        }
    }
}
