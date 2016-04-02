package jp.itohiro.playground.serviceloader;

import java.util.ServiceLoader;

/**
 * Created by hiroshi on 12/13/15.
 */
public class Main {
    public static void main(String[] args) {
        for(JdbcDriver driver : ServiceLoader.load(JdbcDriver.class))
        {
            System.out.println(driver.url());
        }
    }
}
