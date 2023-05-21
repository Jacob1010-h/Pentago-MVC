package game;

import java.math.BigInteger;

public class Trinary {

    public Trinary() {
    }


    //convert trinary to decimal
    public static BigInteger toDecimal(BigInteger value) {
        BigInteger ret = BigInteger.ZERO;
        BigInteger factor = BigInteger.ONE;
        // when value is greater than 0
        while (value.compareTo(BigInteger.ZERO) > 0) {
            ret = ret.add(value.mod(BigInteger.TEN).multiply(factor));
            value = value.divide(BigInteger.TEN);
            factor = factor.multiply(BigInteger.valueOf(3));
        }
        return ret;
    }

    public static BigInteger toTrinary(BigInteger num) {
        BigInteger ret = BigInteger.ZERO;
        BigInteger factor = BigInteger.ONE;

        while (num.compareTo(BigInteger.ZERO) > 0) {
            ret = ret.add(num.mod(BigInteger.valueOf(3)).multiply(factor));
            num = num.divide(BigInteger.valueOf(3));
            factor = factor.multiply(BigInteger.TEN);
        }
        return ret;
    }

}
