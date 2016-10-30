package main;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Maciek on 2016-10-25.
 */
public class UserInputParserTest {

    @Test
    public void parseToIntegersTest(){
        //given
        String correctInput = "12 23 34 45 6 7";
        String incorrectInput = "s d f 1 2 3";
        String emptyMessage = "";
        String zeroValueStillCorrect = "0";
        String valueWithMoreSpacesStillCorrect = "0  12   12 12";
        String crazyLongCorrectValue = "1 2 3 43 54656 57767345 34535 123 123 32";
        //when
        int[] correctInts = UserInputParser.parseToIntegers(correctInput);
        int[] nullInts = UserInputParser.parseToIntegers(incorrectInput);
        int[] emptyMessageInts = UserInputParser.parseToIntegers(emptyMessage);
        int[] zeroValueStillCorrectMessage = UserInputParser.parseToIntegers(zeroValueStillCorrect);
        int[] crazyLongCorrectValueMessage = UserInputParser.parseToIntegers(crazyLongCorrectValue);
        int[] valueWithMoreSpacesStillCorrectMessage = UserInputParser.parseToIntegers(valueWithMoreSpacesStillCorrect);
        //then
        assertNotNull(correctInts);
        assertNotNull(zeroValueStillCorrectMessage);
        assertNotNull(zeroValueStillCorrect);
        assertNotNull(crazyLongCorrectValueMessage);
        assertNotNull(valueWithMoreSpacesStillCorrectMessage);

        assertNull(nullInts);
        assertNull(emptyMessageInts);

    }
}
