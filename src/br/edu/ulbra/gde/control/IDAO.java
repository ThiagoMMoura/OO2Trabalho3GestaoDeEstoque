package br.edu.ulbra.gde.control;

import br.edu.ulbra.gde.model.DbModel;
import java.sql.*;

/**
 *
 * @author Douglas, Thiago
 */
public interface IDAO {

    public DbModel getObjectByResultSet(ResultSet resultSet) throws SQLException;

    public void setStatementParameters(PreparedStatement stmt, DbModel dm, boolean id)
            throws SQLException;
}
