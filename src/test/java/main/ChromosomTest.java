package main;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Maciek on 2016-10-29.
 */
public class ChromosomTest {

    @Test
    public void shouldReturnTheSameValue(){
        //given
        double positiveValue = 23.45;
        double negativeValue = -23.45;
        double zero = 0;


        //when
        int[] positiveBits = Operations.changeIntoBits(positiveValue);
        int[] negativeBits = Operations.changeIntoBits(negativeValue);
        int[] zeroBits = Operations.changeIntoBits(zero);

        Chromosom posChrom = new Chromosom(positiveBits);
        Chromosom negChrom = new Chromosom(negativeBits);
        Chromosom zeroChrom = new Chromosom(zeroBits);

        assertEquals(posChrom.getChromosomValue(), 23.45, 0);
        assertEquals(negChrom.getChromosomValue(), -23.45, 0);
        assertEquals(zeroChrom.getChromosomValue(), 0, 0);

    }



}
