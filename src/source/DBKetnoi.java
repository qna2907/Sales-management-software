package source;

import java.sql.*;

public class DBKetnoi {

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://LAPTOP-V6UP9SRB\\SQLEXPRESS:1433;databaseName=QLBH"
                    + ";encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
            String username = "sa";
            String password = "123";
            conn = DriverManager.getConnection(connectionUrl, username, password);
            if (conn != null) {
                System.out.println("Connection Passed!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return conn;
    }
}
