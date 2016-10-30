package main;

import util.Generator;
import util.Rounder;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciek on 2016-10-26.
 */
public class Operations {

    private final int minRange;

    private final int maxRange;

    public Operations(int minRange, int maxRange){
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    /**
     * @param amount number of variables to generate
     * @return random Doubles.
     */
    public double [] getRandomNumbers(int amount){
        double [] randomDoubles = new double[amount];
        for(int i = 0; i < amount; i++){
            double randomDouble = Generator.generateRandomDoubleWithLimits(minRange, maxRange);
            //skip when random value is zero
            if(valueIsZero(randomDouble)){
                i--;
                continue;
            }
            randomDoubles[i] = Rounder.round(randomDouble, 2);
        }
        return randomDoubles;
    }

    private boolean valueIsZero(double randomValue){
        return randomValue == 0;
    }
    /**
     *
     * @param doubleNumber change into bits representation
     * @return int array with double variable bits representation
     */
    public static int [] changeIntoBits(double doubleNumber){
        long longBits = Double.doubleToLongBits(doubleNumber);
        char[] longBitLetters = Long.toBinaryString(longBits).toCharArray();
        int [] bits = new int [longBitLetters.length];

        for(int i = 0 ; i < longBitLetters.length; i++){
            bits[i] = Character.getNumericValue(longBitLetters[i]);
        }
        return bits;
    }

    /**
     * @param bits that represents chromosome value
     * @return
     */
    public static double changeBitsIntoDoubleValue(int [] bits){
        String bitsString = "";
        for(int bit : bits){
            bitsString += bit + "";
        }
        return Rounder.round(Double.longBitsToDouble(new BigInteger(bitsString, 2).longValue()), 2);
    }

    public List<Chromosom> generatePopulation(double [] numbers){
        List<Chromosom> chromosoms = new ArrayList<Chromosom>();
        for(double number : numbers){
            chromosoms.add(new Chromosom(changeIntoBits(number)));
        }
        return chromosoms;
    }

}
