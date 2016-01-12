package jp.itohiro.playground.rsa;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class EuclidTest {
    @Test
    public void gcd(){
        Euclid euclid = new Euclid();
        Assert.assertEquals(BigInteger.valueOf(2),
                euclid.gcd(BigInteger.valueOf(4), BigInteger.valueOf(6)));
        Assert.assertEquals(BigInteger.valueOf(6),
                euclid.gcd(BigInteger.valueOf(78), BigInteger.valueOf(66)));
        Assert.assertEquals(BigInteger.valueOf(173),
                euclid.gcd(BigInteger.valueOf(135632), BigInteger.valueOf(44461)));
    }
}
