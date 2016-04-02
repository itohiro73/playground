package jp.itohiro.playground.di.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by hiroshi on 5/28/15.
 */
public class GuiceApp {
    @Inject
    private HellowWorld helloWorld;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

            }
        });
        GuiceApp main = injector.getInstance(GuiceApp.class);
        main.helloWorld.hello();
    }
}
