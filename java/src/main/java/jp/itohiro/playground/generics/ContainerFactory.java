package jp.itohiro.playground.generics;

public interface ContainerFactory<T> {
    <T> Container<T> with(T... elements);
}

