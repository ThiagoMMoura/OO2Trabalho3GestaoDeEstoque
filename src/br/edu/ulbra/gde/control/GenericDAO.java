package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
public class GenericDAO {

    public static final String WHERE_ID = " where id = ?";

    protected Connection conexao;
    protected String nomeTabela;
    protected String[] colunas;

    public String getStringColunas(String separator) {
        return String.join(separator, this.colunas);
    }

    public String getInterrogacoes(int n) {
        String[] array = new String[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = "?";
        }
        return String.join(", ", array);
    }

    public String getSelect(String whereClause) {
        String select = "select id, " + this.getStringColunas(", ")
                + " from " + this.nomeTabela;
        if (whereClause != null) {
            select += whereClause;
        }
        return select;
    }

    public String getInsert() {
        String insert = "insert into " + this.nomeTabela
                + " ( " + this.getStringColunas(", ") + ") "
                + "values (" + this.getInterrogacoes(this.colunas.length) + ")";
        return insert;
    }

    public String getUpdate(String whereClause) {
        String update = "update " + this.nomeTabela + " set "
                + this.getStringColunas(" = ?,") + " = ?";
        if (whereClause != null) {
            update += whereClause;
        }
        return update;
    }

    public String getDelete(String whereClause) {
        String delete = "delete from " + this.nomeTabela;
        if (whereClause != null) {
            delete += whereClause;
        }
        return delete;
    }

    public DbModel getObjectById(int id) throws SQLException {

        PreparedStatement stmt = this.conexao.prepareStatement(this.getSelect(WHERE_ID));
        stmt.setInt(1, id);

        ResultSet retorno = stmt.executeQuery();
        DbModel c = null;

        try {
            if (retorno.next()) {
                c = this.getObjectByResultSet(retorno);
            }
        } finally {
            retorno.close();
            stmt.close();
            return c;
        }
    }

    public DbModel getObjectByResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    public ArrayList<DbModel> getAll() throws SQLException {

        PreparedStatement stmt = conexao.prepareStatement(this.getSelect(null));

        ArrayList<DbModel> lista = new ArrayList<>();

        ResultSet retorno = stmt.executeQuery();
        while (retorno.next()) {
            lista.add(this.getObjectByResultSet(retorno));
        }
        retorno.close();

        stmt.close();
        return lista;
    }

    public void save(DbModel dm) throws SQLException {

        DbModel dbModel = dm;

        PreparedStatement stmt;
        DbModel c = this.getObjectById(dm.getId());

        if (c == null) {
            stmt = conexao.prepareStatement(this.getInsert(), Statement.RETURN_GENERATED_KEYS);
            this.setStatementParameters(stmt, dm, false);
            stmt.executeUpdate();

            ResultSet retId = stmt.getGeneratedKeys();
            if (retId.next()) {
                dm.setId(retId.getInt(1));
            }
            retId.close();
        } else {
            stmt = conexao.prepareStatement(getUpdate(WHERE_ID));
            this.setStatementParameters(stmt, dm, true);
            stmt.executeUpdate();
        }

        stmt.close();
    }

    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id)
            throws SQLException {
    }

    public void delete(DbModel dm) throws SQLException {

        DbModel c = this.getObjectById(dm.getId());

        if (c != null) {
            PreparedStatement stmt
                    = conexao.prepareStatement(this.getDelete(WHERE_ID));
            stmt.setInt(1, c.getId());
            stmt.execute();
            stmt.close();
        }
    }
}
