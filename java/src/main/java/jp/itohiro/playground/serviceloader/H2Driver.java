package jp.itohiro.playground.serviceloader;

public class H2Driver implements JdbcDriver {
    @Override
    public String url() {
        return "jdbc:h2:";
    }
}
