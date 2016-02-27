package jp.itohiro.playground.fp;

public class Functions<A, B, C> {
    public Function1<B, C> partial(final A a, Function2<A, B, C> f){
        return b -> f.apply(a, b);
    }

    public Function12<A, B, C> curry(Function2<A, B, C> f){
        return a -> b -> f.apply(a, b);
    }

    public Function2<A, B, C> uncurry(Function12<A, B, C> f){
        return (a, b) -> f.apply(a).apply(b);
    }

    public Function1<A, C> compose(Function1<B, C> f, Function1<A, B> g){
        return a -> f.apply(g.apply(a));
    }
}

interface Function2<A, B, C>{
    C apply(A a, B b);
}

interface Function1<A, B>{
    B apply(A a);
}

interface Function11<A, B, C>{
    Function1<B, C> apply(Function1<A, B> f);
}

interface Function12<A, B, C>{
    Function1<B, C> apply(A a);
}