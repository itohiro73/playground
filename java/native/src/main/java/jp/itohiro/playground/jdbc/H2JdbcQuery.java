package jp.itohiro.playground.jdbc;

import java.sql.*;

public class H2JdbcQuery {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");

        DatabaseMetaData meta = conn.getMetaData();

        System.out.println(meta.getDriverName() + " " + meta.getDriverVersion());
        System.out.println(meta.getDriverMajorVersion());
        System.out.println(meta.getDriverMinorVersion());


        Statement stmt = conn.createStatement();

        String createTable = "CREATE TABLE USERS " +
                "(id INTEGER not NULL, " +
                " username VARCHAR(255)," +
                " first_name VARCHAR(255), " +
                " last_name VARCHAR(255)," +
                " PRIMARY KEY (id))";
        stmt.executeUpdate(createTable);

        String insertUsers1 = "INSERT INTO USERS VALUES (1, 'itohro', 'Hiroshi', 'Ito')";
        String insertUsers2 = "INSERT INTO USERS VALUES (2, 'itokao', 'Kaoru', 'Ito')";
        String insertUsers3 = "INSERT INTO USERS VALUES (3, 'itomao', 'Mao', 'Ito')";
        stmt.executeUpdate(insertUsers1);
        stmt.executeUpdate(insertUsers2);
        stmt.executeUpdate(insertUsers3);

        String select = "SELECT * from USERS ";
        ResultSet rs = stmt.executeQuery(select);
        while(rs.next()){
            System.out.println(rs.getString("username") + ": " + rs.getString("first_name") + " " + rs.getString("last_name"));
        }
        conn.close();
    }
}
