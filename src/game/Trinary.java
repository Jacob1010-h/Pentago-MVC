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

    public static int[] numToIntArray(BigInteger num) {
        int[] ret = new int[num.toString().length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.parseInt(num.toString().substring(i, i + 1));
        }
        return ret;
    }

    public static int[][]  numTo2DIntArray(BigInteger num) {
        int[][] ret = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        int[] numArray = numToIntArray(num);
        int index = 3;
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            index -= 3;
            if (col == 3) {
                index -= 9;
            }
            for (int row = 5; row >= 0; row--) {
                if (row < 3) {
                    ret[row][col] = numArray[index + 6];
                }
                else {
                    ret[row][col] = numArray[index];
                }
                index++;
            }
        }
        return ret;
    }

}
