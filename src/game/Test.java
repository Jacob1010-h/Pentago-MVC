package game;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        // two to the power of 63
        long num = (2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L *  2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L );
        Trinary t = new Trinary(num);
        System.out.println(t.getValue());
        t.toTrinary();
        System.out.println(t.getValue());

    }
}
