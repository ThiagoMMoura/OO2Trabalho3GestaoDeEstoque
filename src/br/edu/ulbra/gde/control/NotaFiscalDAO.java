package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import br.edu.ulbra.gde.model.NotaFiscal;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public class NotaFiscalDAO extends GenericDAO  {

    protected static NotaFiscalDAO objeto;

    private NotaFiscalDAO() throws SQLException {
        this.conexao = DBAdapter.getConnection();
        this.nomeTabela = "nota_fiscal";
        this.colunas = new String[]{"numero", "serie", "chave_acesso",
            "entrada_saida", "natureza_operacao", "data_emissao",
            "data_entrada_saida", "id_pessoa", "informacoes_complementares"};
    }

    public static ContatoDAO getInstance() throws SQLException {
        if (NotaFiscalDAO.objeto == null) {
            NotaFiscalDAO.objeto = new NotaFiscalDAO();
        }
        return ContatoDAO.objeto;
    }

    @Override
    public NotaFiscal getObjectByResultSet(ResultSet resultSet) throws SQLException {
        int idRet = resultSet.getInt("id");
        int numero = resultSet.getInt(this.colunas[0]);
        String serie = resultSet.getString(this.colunas[1]);
        String chaveAcesso = resultSet.getString(this.colunas[2]);
        int entradaSaida = resultSet.getInt(this.colunas[3]);
        String naturezaOperacao = resultSet.getString(this.colunas[4]);
        Date dataEmissao = Date.valueOf(resultSet.getString(this.colunas[5]));
        Date dataEntradaSaida = Date.valueOf(resultSet.getString(this.colunas[6]));
        int idPessoa = resultSet.getInt(this.colunas[7]);
        String informacoesComplementares = resultSet.getString(this.colunas[8]);

        return new NotaFiscal(idRet, numero, serie, chaveAcesso,
                entradaSaida, naturezaOperacao, dataEmissao,
                dataEntradaSaida, idPessoa, informacoesComplementares);
    }

    @Override
    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id) throws SQLException {
        NotaFiscal nf = (NotaFiscal) dm;

        stmt.setInt(1, nf.getNumero());
        stmt.setString(2, nf.getSerie());
        stmt.setString(3, nf.getChaveAcesso());
        stmt.setInt(4, nf.getEntradaSaida());
        stmt.setString(5, nf.getNaturezaOperacao());
        stmt.setString(6, nf.getDataEmissao().toString());
        stmt.setString(7, nf.getDataEntradaSaida().toString());
        stmt.setInt(8, nf.getIdPessoa());
        stmt.setString(9, nf.getInformacoesComplementares());
        if (id) {
            stmt.setInt(4, nf.getId());
        }
    }

}
