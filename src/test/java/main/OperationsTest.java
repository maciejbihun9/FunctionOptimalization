package main;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Maciek on 2016-10-29.
 */
public class OperationsTest {

    Operations operations;

    private static final int min = -5;

    private static final int max = 5;



    @Before
    public void globalInitalization(){

        operations = new Operations(min, max);

    }

    /*@Test
    public void shouldReturnRandomValuesBetween(){
        //given
        int size = 1000;
        //when
        double[] randomNumbers = operations.getRandomNumbers(1000);
        //then
        assertEquals(randomNumbers.length, size, 0);
        for(double randomNumber : randomNumbers){
            assertEquals(randomNumber >= min && randomNumber <= max, true);

        }

    }

    @Test
    public void shouldChangeBitsIntoDoubleValue(){
        //given
        double testValue = 23.43;
        int [] bits = Operations.changeIntoBits(testValue);

        //when
        double v = Operations.changeBitsIntoDoubleValue(bits);

        //then
        assertEquals(testValue, v, 0);
    }


    @Test
    public void shouldCreatePopulationWithCharactersBetweenGivenNumbers(){
        //given
        double[] randomNumbers = operations.getRandomNumbers(1000);
        List<Chromosom> chromosoms = operations.generatePopulation(randomNumbers);
        for(Chromosom chromosom : chromosoms){
            assertEquals(chromosom.getChromosomValue() >= min && chromosom.getChromosomValue() <= max, true);
            System.out.println("Random numbers  : " + chromosom.getChromosomValue());
        }
    }
*/
    @Test
    public void shouldReturnSomeSpecificValue(){
        //given
        String bits = "1 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 1 0 0 0 1 1 1 1 0 1 0 1 1 1 0 0 0 0 1 0 1 0 0 0 1 1 1 1 0 1 0 1 1 1 0 0 0 0 1 0 1 0 0 1 0";
        String [] bitArray = bits.split(" ");
        int [] bitsInt = new int[bitArray.length];
        int counter = 0;
        for(String string : bitArray){
            int i = Integer.parseInt(string);
            bitsInt[counter++] = i;
        }
        double v = Operations.changeBitsIntoDoubleValue(bitsInt);
        System.out.println("Double value generated : " + v);
        System.out.println("New bid decimal : " + new BigDecimal(v).toPlainString());


    }

}
