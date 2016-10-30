package main;

import exceptions.UnsupportedSignException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Maciek on 2016-10-25.
 */
public class UserInputParser {

    private static final String [] allowedSigns = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static String getUserInput() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        return bufferedReader.readLine();
    }

    public static int [] parseToIntegers(String userInput) {
        String [] inputParameters = userInput.split(" +");
        int [] parsedSigns = new int[inputParameters.length];
        for(int i = 0 ; i < inputParameters.length; i++){
            //check if string contains only numbers
            if(wordDoesNotContainLetters(inputParameters[i]) && isInteger(inputParameters[i])){
                parsedSigns[i] = Integer.parseInt(inputParameters[i]);
            } else {
                return null;
            }
        }
        return parsedSigns;
    }

    public static String printUserIntegerElements(int [] userInput){
        String userInputString = "";
        for(int element : userInput){
            userInputString += element;
        }
        return userInputString;
    }

    public static boolean wordDoesNotContainLetters(String word){
        return word.matches(".*\\d+.*");
    }

    private static boolean isInteger(String word){
        return word.matches("^-?\\d+$");
    }

}
