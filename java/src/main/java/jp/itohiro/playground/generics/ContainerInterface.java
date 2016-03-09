package jp.itohiro.playground.generics;

import java.util.function.Function;

public interface ContainerInterface<T> {
    <V> ContainerInterface<V> map(Function<? extends V, ? extends T> function);
}
