package br.com.cca.commons.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * User: Leandro Antonelli
 * Date: 14/08/20
 */
public class AbstractRowMapper {

    public static boolean hasColumn(ResultSet rs, String columnName) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();

        for (int x = 1; x <= columns; x++) {
            if (columnName.equals(rsmd.getColumnName(x))) {
                return true;
            }
        }

        return false;
    }
}
