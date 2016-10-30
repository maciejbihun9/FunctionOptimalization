package util;

import java.util.Random;

/**
 * Created by Maciek on 2016-10-27.
 */
public class Generator {

    public static int generateRandomInteger(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static double generateRandomDoubleWithLimits(int min, int max){
        return Rounder.round(min + (max - min) * new Random().nextDouble(), 2);
    }

}
