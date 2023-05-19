package game;

import java.math.BigInteger;

public class Trinary {
    private BigInteger value;

    public Trinary(BigInteger value) {
        this.value = value;
    }
    public Trinary() { value = BigInteger.ZERO; }


    //convert trinary to decimal
    public BigInteger toDecimal(BigInteger value) {
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

    public BigInteger toDecimal() {
        BigInteger value = this.value;
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

    public BigInteger toTrinary(BigInteger num) {
        BigInteger ret = BigInteger.ZERO;
        BigInteger factor = BigInteger.ONE;

        while (num.compareTo(BigInteger.ZERO) < 0) {
            ret = ret.add(num.mod(BigInteger.valueOf(3)).multiply(factor));
            num = num.divide(BigInteger.valueOf(3));
            factor = factor.multiply(BigInteger.TEN);
        }
        if(ret.equals(BigInteger.ZERO)) {
            return this.value;
        }
        return ret;
    }

    public BigInteger toTrinary() {
        BigInteger value = this.value;
        BigInteger ret = BigInteger.ZERO;
        BigInteger factor = BigInteger.ONE;

        while (value.compareTo(BigInteger.ZERO) < 0) {
            ret = ret.add(value.mod(BigInteger.valueOf(3)).multiply(factor));
            value = value.divide(BigInteger.valueOf(3));
            factor = factor.multiply(BigInteger.TEN);
        }
        if(ret.equals(BigInteger.ZERO)) {
            return this.value;
        }
        return ret;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

}
