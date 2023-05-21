package game;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.math.BigInteger;
import java.util.Map;

public class Test {

        public static void main(String[] args) throws Exception {
            AI ai = new AI(1);
            long num = 205481007622539795L;

            Map moves = ai.getPosibleMoves(BigInteger.valueOf(num), true);
            System.out.println(moves);
            System.out.println(moves.keySet().toArray()[0].toString());
            System.out.println(Trinary.toTrinary(new BigInteger(moves.keySet().toArray()[0].toString())));
            System.out.println(Trinary.toDecimal(Trinary.toTrinary(new BigInteger(moves.keySet().toArray()[0].toString()))));

        }
}
