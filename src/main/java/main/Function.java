package main;

import util.Rounder;

/**
 * Created by Maciek on 2016-10-25.
 */
public class Function {

    private int[] functionParameters;

    private int size;

    public Function(int[] functionParameters) {
        this.functionParameters = functionParameters;
        size = functionParameters.length;
    }

    //2 * x ^ 2 + 2 * x + 7;
    public double getFunctionResult(double variableValue) {
        double functionResult = 0;
        int counter = size;
        for (int i = 0; i < size; i++) {
            //for each function parameter multiply it whatever user wants.
            double multipliedValue = multiply(variableValue, --counter);
            functionResult += functionParameters[i] * multipliedValue;
        }
        return Rounder.round(functionResult, 2);
    }

    private double multiply(double value, int howMany) {
        if (howMany == 0)
            return 1;
        else
            return Math.pow(value, howMany);
    }

    public int[] getFunctionParameters() {
        return functionParameters;
    }

}
