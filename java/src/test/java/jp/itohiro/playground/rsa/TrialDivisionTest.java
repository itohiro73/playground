package jp.itohiro.playground.rsa;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TrialDivisionTest {
    @Test
    public void gcd(){
        TrialDivision trialDivision = new TrialDivision();
        Assert.assertEquals(BigInteger.valueOf(2),
                trialDivision.gcd(BigInteger.valueOf(4), BigInteger.valueOf(6)));
        Assert.assertEquals(BigInteger.valueOf(6),
                trialDivision.gcd(BigInteger.valueOf(78), BigInteger.valueOf(66)));
    }
}
