package main;

import org.junit.Test;
import util.Generator;

import static org.junit.Assert.*;

/**
 * Created by Maciek on 2016-10-27.
 */
public class GeneratorTest {

    @Test
    public void generateRandomIntegerTest() {
        //given
        int min = 10;
        int max = 20;

        for (int i = 0; i < 100; i++) {
            //when
            int generatedValue = Generator.generateRandomInteger(min, max);
            //then
            boolean between = generatedValue <= 20 && generatedValue >= 10;
            assertTrue(between);
        }
    }

    @Test
    public void generateRandomDoubleTest() {
        //given
        int min = 10;
        int max = 20;

        for (int i = 0; i < 100; i++) {
            //when
            double generatedValue = Generator.generateRandomDoubleWithLimits(min, max);
            //then
            boolean between = generatedValue <= 20 && generatedValue >= 10;
            System.out.println("generated value : " + generatedValue);
            assertTrue(between);
        }
    }
}
