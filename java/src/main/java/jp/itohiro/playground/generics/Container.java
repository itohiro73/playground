package jp.itohiro.playground.generics;

import java.util.function.Function;

public class Container<T> implements ContainerInterface<T>{
    @Override
    public <V> Container<V> map(Function<? extends V, ? extends T> function) {
        return null;
    }
}
