package jp.itohiro.playground.rsa;

import java.math.BigInteger;

public class Euclid {
    public BigInteger gcd(BigInteger a, BigInteger b) {
        if(a.signum() != 1 || b.signum() != 1){
            StringBuilder message = new StringBuilder();
            if(a.signum() !=1 ) message.append(a).append(" is not a valid imput. ");
            if(b.signum() !=1 ) message.append(b).append(" is not a valid imput. ");
            throw new IllegalArgumentException(message.toString());
        }

        for(BigInteger r = a.remainder(b); !r.equals(BigInteger.ZERO); r = a.remainder(b)){
            a = b;
            b = r;
        }
        return b;
    }
}
