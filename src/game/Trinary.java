package game;

public class Trinary {
    private int value;

    public Trinary(int value) {
        this.value = value;
    }

    //convert trinary to decimal
    public int toDecimal(int value) {
        int ret = 0, factor = 1;
        while (value > 0) {
            ret += value % 10 * factor;
            value /= 10;
            factor *= 3;
        }
        return ret;
    }
    public int toTrinary(int num) {
        int ret = 0, factor = 1;
        while (num > 0) {
            ret += num % 3 * factor;
            num /= 3;
            factor *= 10;
        }
        return ret;

    }

    public void setValue() {
        this.value = value;
    }

}
