package jp.itohiro.playground.serviceloader;

public class PostgreSqlDriver implements JdbcDriver {
    @Override
    public String url() {
        return "jdbc:postgresql:";
    }
}
