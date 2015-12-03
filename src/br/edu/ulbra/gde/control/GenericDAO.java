package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import java.sql.*;
import java.util.*;
import org.sqlite.util.StringUtils;

/**
 *
 * @author Douglas
 */
public abstract class GenericDAO {

    public static final String WHERE_ID = "id = ?";

    protected Connection conexao;
    protected String nomeTabela;
    protected String[] colunas;

    public String getStringColunas(String separator) {
        //String value = String.join(separator, this.colunas);
        List<String> stringList = new ArrayList<>(Arrays.asList(this.colunas));
        String joinedResult = StringUtils.join(stringList, separator);
        return joinedResult;
    }

    public String getInterrogacoes(int n) {
        String[] array = new String[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = "?";
        }
        //String anterior = String.join(", ", array);
        List<String> stringList = new ArrayList<>(Arrays.asList(array));
        String joinedResult = StringUtils.join(stringList, ", ");
        return joinedResult;
    }

    public String getSelect(String whereClause) {
        String select = "select id, " + this.getStringColunas(", ")
                + " from " + this.nomeTabela;
        if (whereClause != null) {
            select += " where " + whereClause;
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
            update += " where " + whereClause;
        }
        return update;
    }

    public String getDelete(String whereClause) {
        String delete = "delete from " + this.nomeTabela;
        if (whereClause != null) {
            delete += " where " + whereClause;
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

    public ArrayList<DbModel> getAllWhere(String whereClause) throws SQLException {

        PreparedStatement stmt = conexao.prepareStatement(this.getSelect(whereClause));

        ArrayList<DbModel> lista = new ArrayList<>();

        ResultSet retorno = stmt.executeQuery();
        while (retorno.next()) {
            lista.add(this.getObjectByResultSet(retorno));
        }
        retorno.close();

        stmt.close();
        return lista;
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

    public abstract DbModel getObjectByResultSet(ResultSet resultSet) throws SQLException;

    public abstract void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id)
            throws SQLException;
}
