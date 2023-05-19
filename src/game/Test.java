package game;

import java.math.BigInteger;
import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        Trinary t = new Trinary(BigInteger.valueOf(12));
        System.out.println(t.toDecimal());
        System.out.println(t.toTrinary());
    }
}
