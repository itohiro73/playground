package jp.itohiro.playground.fp_in_scala;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.FixedSizeList;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.tuple.Tuples;

public class Cafe {
    public Pair<Coffee, Charge> buyCoffee(CreditCard cc){
        Coffee cup = new Coffee();
        return Tuples.pair(cup, new Charge(cc, cup.price));
    }

    Pair<LazyIterable<Coffee>, Charge> buyCoffees(CreditCard cc, int n){
        ImmutableList<Pair<Coffee, Charge>> purchases = IntInterval.oneTo(n).collect(i -> buyCoffee(cc)).toImmutable();
        LazyIterable<Pair<Coffee, Charge>> pairs = purchases.asLazy();
        return Tuples.pair(pairs.collect(Pair::getOne), pairs.collect(Pair::getTwo).toList().injectInto(new Charge(cc, 0), Charge::combine));
    }

    ImmutableList<Charge> coalesce(ImmutableList<Charge> charges){
        return charges.asLazy().groupBy(Charge::getCc).valuesView().collect(chargesPerCc -> charges.injectInto(new Charge(charges.get(0).getCc(), 0), Charge::combine)).toList().toImmutable();
    }

    private class Coffee {
        long price;

        public long price() {
            return price;
        }
    }

}
