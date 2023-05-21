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

    public static int[][] numTo2dArray(BigInteger num) {
        // The quadrant order is x-major: the first 16 bits are lower left, the next 16 bits are upper left, then lower right and upper right.
        int[][] ret = new int[6][6];
        int[] numArray = numToIntArray(num);
        int index = 0;
        boolean bottomHalf = true;
        // loop through the array, assigning digits from num into the 2d array
        for (int row = 0; row < ret.length; row++) {
            // bottom left
            if (row < 3 && bottomHalf) {
                for (int col = ret[row].length-1; col >= ret[row].length/2; col--) {
                    ret[col][row] = numArray[index];
                    index++;
                }
                if (row == 2) {
                    bottomHalf = false;
                    row = -1;
                }
            }
            //top left / right
            else if (!bottomHalf) {
                for (int col = 0; col < ret[row].length/2; col++) {
                    ret[col][row] = numArray[index];
                    index++;
                }
                if (row == ret.length - 1) {
                    row = 2;
                    bottomHalf = true;
                }
            }
            // bottom right
            else {
                for (int col = ret[row].length-1; col >= ret[row].length/2; col--) {
                    ret[col][row] = numArray[index];
                    index++;
                }
            }
        }
        return ret;
    }

}
