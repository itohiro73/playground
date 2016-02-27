package jp.itohiro.playground.fp;

import org.junit.Assert;
import org.junit.Test;

public class FpTest {
    @Test
    public void testFunctions(){
        Function2<Integer, Integer, Integer> add = (a, b) -> a + b;
        Function12<Integer, Integer, Integer> addCurry = a -> b -> a + b;
        Functions<Integer, Integer, Integer> functions = new Functions<>();
        Functions<String, String, String> functionsString = new Functions<>();
        Assert.assertEquals(3, (int)functions.partial(1, add).apply(2));
        Assert.assertEquals(3, (int)functions.curry(add).apply(1).apply(2));
        Assert.assertEquals(3, (int)functions.uncurry(addCurry).apply(1, 2));
        Assert.assertEquals("HELLO WORLD", functionsString.compose(String::toUpperCase, s -> "Hello " + s).apply("World"));
    }
}
