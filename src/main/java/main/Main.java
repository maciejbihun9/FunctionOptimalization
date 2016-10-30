package main;

import exceptions.UnsupportedSignException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Maciek on 2016-10-25.
 */
public class Main {

    private static int lowerLimitNumber = 0;

    private static int upperLimitNumber = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("***********Welcome in Maciej Bihun multi variables function optimalization program***********");
        System.out.println("Example function parameters may look like this:");
        System.out.println("Function: 4*x^3 + 4*x^2 + x - 1  -> 4 4 1 -1 ");
        System.out.println("Please, write a function parameters with spaces between: ");

        Operations operations;

        //get user input parameters from console
        int[] userInputParameters = getUserInputParameters();

        //get task limits
        while(true){
            System.out.println("Please write task limits as integers:");
            System.out.print("from: ");
            String lowerLimit = UserInputParser.getUserInput();
            System.out.print("To: ");
            String upperLimit = UserInputParser.getUserInput();
            if(!UserInputParser.wordDoesNotContainLetters(lowerLimit) || !UserInputParser.wordDoesNotContainLetters(upperLimit)){
                //skip iteration
            } else {
                lowerLimitNumber = Integer.parseInt(lowerLimit.replaceAll("\\s+",""));
                upperLimitNumber = Integer.parseInt(upperLimit.replaceAll("\\s+",""));
                if(lowerLimitNumber < upperLimitNumber){
                    operations = new Operations(lowerLimitNumber, upperLimitNumber);
                    break;
                }
                System.out.println("Please provide lower limit lower that upper limit!!!:");
            }
        }

        //generate random starting population chromosomes
        double[] startingNumbers = operations.getRandomNumbers(GeneticEvolution.popultaion_size);

        //generate starting population
        List<Chromosom> startingPopulation = operations.generatePopulation(startingNumbers);

        //get resolution
        GeneticEvolution geneticEvolution = new GeneticEvolution(userInputParameters, lowerLimitNumber, upperLimitNumber);
        Chromosom masterChrom = geneticEvolution.getMasterChrom(startingPopulation);

        System.out.println("End the result is :" + masterChrom.getChromosomValue());

    }

    private static int [] getUserInputParameters(){
        int[] inputIntegers;
        String inputLine = null;
        while(true){
            try {
                inputLine = UserInputParser.getUserInput();
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputIntegers = UserInputParser.parseToIntegers(inputLine);
            if(inputIntegers != null)
                break;
            System.out.println("Please provide integer values and do not start with space!!!");
        }
        System.out.println("Your data: " + UserInputParser.printUserIntegerElements(inputIntegers));
        return inputIntegers;
    }


}
