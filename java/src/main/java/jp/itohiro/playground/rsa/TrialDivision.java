package jp.itohiro.playground.rsa;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.math.BigInteger;

public class TrialDivision {
    public BigInteger gcd(BigInteger a, BigInteger b){
        if(a.signum() != 1 || b.signum() != 1){
            StringBuilder message = new StringBuilder();
            if(a.signum() !=1 ) message.append(a).append(" is not a valid imput. ");
            if(b.signum() !=1 ) message.append(b).append(" is not a valid imput. ");
            throw new IllegalArgumentException(message.toString());
        }

        BigInteger g = BigInteger.ONE;
        if(a.compareTo(b) < 0) {
            BigInteger t = a;
            a = b;
            b = t;
        }

        for(BigInteger n = BigInteger.valueOf(2); n.compareTo(b) <= 0; n = n.add(BigInteger.ONE)){
            while(a.remainder(n).equals(BigInteger.ZERO)
                    && b.remainder(n).equals(BigInteger.ZERO)){
                g = n.multiply(g);
                a = a.divide(n);
                b = b.divide(n);
            }
        }

        return g;
    }
}
