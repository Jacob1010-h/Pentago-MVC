package game;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.math.BigInteger;

public class Test {

        public static void main(String[] args) throws Exception {
            AI ai = new AI(1);
            System.out.println(ai.getPosibleMoves(new Trinary(BigInteger.ZERO)));
        }
}
