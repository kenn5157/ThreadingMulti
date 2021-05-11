package MyThreading.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {

    private SQLServerDataSource dataSource;

    public DatabaseConnector(){
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("Threading");
        dataSource.setUser("CSe20B_11");
        dataSource.setPassword("bwa69rgq");
        dataSource.setPortNumber(1433);
    }

    public Connection getConneciton() throws SQLServerException {
        return dataSource.getConnection();
    }

    public void testConneciton() throws SQLException {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        try (Connection connection = databaseConnector.getConneciton()){
            System.out.println("Is it open? " + !connection.isClosed());
        }
    }

}
