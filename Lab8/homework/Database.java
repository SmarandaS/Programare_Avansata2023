package homework;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgrespass";
    private static ComboPooledDataSource cpds = null;

    private Database() {}

    public static Connection getConnection() throws SQLException {
        if (cpds == null) {
            initConnectionPool();
        }
        return cpds.getConnection();
    }

    private static void initConnectionPool() {
        cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER);
        cpds.setPassword(PASSWORD);
        cpds.setMaxPoolSize(50); // maximum number of connections in the pool
        cpds.setMinPoolSize(3); // minimum number of connections in the pool
        cpds.setAcquireIncrement(3); // number of connections to add when the pool is exhausted

    }

    public static void closeConnectionPool() {
        if (cpds != null) {
            cpds.close();
        }
    }
}
