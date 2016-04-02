package jp.itohiro.playground.orm.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.h2.Driver;

import java.sql.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by hiroshi on 5/26/15.
 */
public class H2ConnectionTest {
    Connection conn;

    @Before
        public void setUp() throws SQLException {
            Driver.load();
            conn = DriverManager.getConnection("jdbc:h2:mem:test");
    }

    @After
    public void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    public void test() throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute("create table test (ID INT PRIMARY KEY, NAME VARCHAR)");
        statement.execute("insert into test values (1, 'Hiroshi Ito')");

        ResultSet rs = statement.executeQuery("select * from test");
        assertThat(rs.next(), is(true));
        assertThat(rs.getInt("ID"), is(1));
        assertThat(rs.getString("NAME"), is("Hiroshi Ito"));
    }
}
