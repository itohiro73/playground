package jp.itohiro.playground.serviceloader;

public class MySqlDriver implements JdbcDriver {
    @Override
    public String url() {
        return "jdbc:mysql:";
    }
}
