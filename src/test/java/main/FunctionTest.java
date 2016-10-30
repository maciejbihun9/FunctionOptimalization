package main;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Maciek on 2016-10-25.
 */
public class FunctionTest {


    @Test
    public void shouldReturnConvenientFunctionResult3(){
        //given
        int [] functionParameters = {1, 1}; // x + 1
        final Function geneticFunction = new Function(functionParameters);
        double value = 2;
        //when
        double functionResult = geneticFunction.getFunctionResult(value);
        //then
        assertEquals(functionResult, 3, 0);
    }

    //TESTING FUNCTION RESULT FUNCTION

    @Test
    public void shouldReturnConvenientFunctionResult(){
        //given
        int [] functionParameters = {1}; // 1
        final Function geneticFunction = new Function(functionParameters);
        double value = 6;
        //when
        double functionResult = geneticFunction.getFunctionResult(value);
        //then
        assertEquals(functionResult, 1, 0);
    }


    @Test
    public void shouldReturnConvenientFunctionResult2(){
        //given
        int [] functionParameters = {5, 4, 1, 8}; // 5 * x^3 + 4 * x ^ 2 + x + 8
        final Function geneticFunction = new Function(functionParameters);
        double value = 2;
        //when
        double functionResult = geneticFunction.getFunctionResult(value);
        //then
        assertEquals(functionResult, 66, 0);
    }

    @Test
    public void shouldReturnConvenientFunctionResult4(){
        //given
        int [] functionParameters = {6, 2, 1, 4}; // 6 * x^3 + 2 * x ^ 2 + x + 4
        final Function geneticFunction = new Function(functionParameters);
        double value = 2;
        //when
        double functionResult = geneticFunction.getFunctionResult(value);
        //then
        assertEquals(functionResult, 62, 0);
    }


}
