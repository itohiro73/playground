package jp.itohiro.playground.orm.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by hiroshi on 5/26/15.
 */
public class PostgreSQLConnectionTest {

    @Test
    @Ignore
    public void test() throws SQLException {
        try(
                Connection conn
                        = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb");
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("select * from test");)
        {
            assertThat(rs.next(), is(true));
            assertThat(rs.getInt("ID"), is(1));
            assertThat(rs.getString("NAME"), is("Hiroshi Ito"));
        }
    }
}
