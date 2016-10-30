package main;

import java.util.*;

import util.*;

/**
 * Created by Maciek on 2016-10-26.
 */
public class GeneticEvolution {

    //POPULATION SIZE NUMBERS

    public static final int popultaion_size = 100;

    //GENETIC EVOLUTION PARAMETERS

    private static final double mutation_pos = 0.01;

    //TASK LIMITS

    private int lowerLimitNumber = 0;

    private int upperLimitNumber = 0;

    private Function geneticFunction;

    public GeneticEvolution(int [] geneticFunctionParameters, int min, int max){
         lowerLimitNumber = min;
         upperLimitNumber = max;
         this.geneticFunction = new Function(geneticFunctionParameters);
    }

    public Chromosom getMasterChrom(List<Chromosom> startingPopulation){
        List<Chromosom> newPopulationGroup = startingPopulation;
        List<Double> iterationResults = new ArrayList<Double>();
        int iterationNumber = 0;
        while (true){
            newPopulationGroup = populationIteration(newPopulationGroup);
            //generate new 50 chromosomes
            newPopulationGroup.addAll(generateRandomChromosoms(50));

            double populationIterationSum = 0;

            for(Chromosom chromosom : newPopulationGroup){
                populationIterationSum += geneticFunction.getFunctionResult(chromosom.getChromosomValue());
            }

            iterationResults.add(populationIterationSum);

            if(shouldEndEvolution(iterationNumber)){
                break;
            }

            iterationNumber++;
        }
        return findTheBestCharacter(newPopulationGroup);
    }

    public  List<Chromosom> populationIteration(List<Chromosom> populationChroms){
        List<Chromosom> survivedChromosomes = new ArrayList<Chromosom>();
        List<Chromosom> charactersForGeneticOperations = getBestCharactersBetween(populationChroms,10, 49);
        List<Chromosom> bestCharacters  = getBestCharactersBetween(populationChroms, 0, 9);
        for(Chromosom chrom : charactersForGeneticOperations){
            if(shouldMutate()){
                mutate(chrom);
            }
        }
        List<Chromosom> crossedChroms = new ArrayList<Chromosom>();
        while(charactersForGeneticOperations.size() != 0){
            List<Chromosom> crossedDouble = crossover(charactersForGeneticOperations.get(0), charactersForGeneticOperations.get(1));
            charactersForGeneticOperations.remove(1);
            charactersForGeneticOperations.remove(0);
            crossedChroms.addAll(crossedDouble);
        }
        survivedChromosomes.addAll(bestCharacters);
        survivedChromosomes.addAll(crossedChroms);
        return survivedChromosomes;
    }

    /**
     * @param population list of chromosomes
     * @param lowerLimit get chromosomes ordered by it's genetic function result from that number in the list
     * @param upperLimit get chromosomes ordered by it's genetic function result to that number in the list
     * @return list of chromosomes between given numbers in the list
     */
    public List<Chromosom> getBestCharactersBetween(List<Chromosom> population, int lowerLimit, int upperLimit){
        List<Chromosom> bestCharaters = new ArrayList<Chromosom>();
        Map<Double, Chromosom> bestCharactersMap = new TreeMap<Double, Chromosom>();
        for(Chromosom chromosom : population){
            double chromFunctionResult = geneticFunction.getFunctionResult(chromosom.getChromosomValue());
            bestCharactersMap.put(chromFunctionResult, chromosom);
        }
        int iterationCounter = 0;
        for(Map.Entry<Double, Chromosom> entry : bestCharactersMap.entrySet()) {
            if(iterationCounter >= lowerLimit && iterationCounter <= upperLimit){
                bestCharaters.add(entry.getValue());
            }
            iterationCounter++;
        }
        return bestCharaters;
    }

    public  List<Chromosom> crossover(Chromosom chrom1, Chromosom chrom2){
        List<Chromosom> crossedChroms = new ArrayList<Chromosom>();
        int fenotypeSize = chrom2.getChromBits().length;
        int crossPoint = Generator.generateRandomInteger(0, fenotypeSize/2);
        for(int i = 0 ; i < crossPoint; i++){
            int chrom1Bit = chrom1.getChromBits()[i];
            chrom1.getChromBits()[i] = chrom2.getChromBits()[i];
            chrom2.getChromBits()[i] = chrom1Bit;
        }
        crossedChroms.add(chrom1);
        crossedChroms.add(chrom2);
        return crossedChroms;
    }

    public void mutate(Chromosom chromosom){
        int[] chromBits = chromosom.getChromBits();
        int generatedValue = Generator.generateRandomInteger(0, chromBits.length - 1);
        chromBits[generatedValue] = changeBit(chromBits[generatedValue]);
        chromosom.setChromBits(chromBits);
    }

    public List<Chromosom> generateRandomChromosoms(int amount){
        Operations operations = new Operations(lowerLimitNumber, upperLimitNumber);
        double[] randomNumbers = operations.getRandomNumbers(amount);
        return operations.generatePopulation(randomNumbers);
    }

    //--------------------------------------------------------
    //---------------------HELPER METHODS---------------------
    //--------------------------------------------------------

    private  int changeBit(int bit){
        if(bit == 1)
            return 0;
        else
            return 1;
    }

    private  boolean shouldMutate(){
        return Generator.generateRandomDoubleWithLimits(0, 1) < mutation_pos;
    }

    private  boolean shouldEndEvolution(int iterationNumber){
        return iterationNumber > 300;
    }

    private boolean fulfilLimits(double value){
        return value < upperLimitNumber && value > lowerLimitNumber;
    }

    private Chromosom getFirstChromIncludingLimits(List<Chromosom> chromosoms){
        for(Chromosom chromosom : chromosoms){
            if(fulfilLimits(chromosom.getChromosomValue()))
                return chromosom;
        }
       return null;
    }

    public Chromosom findTheBestCharacter(List<Chromosom> chromosoms){
        Chromosom theLowestChromosom = getFirstChromIncludingLimits(chromosoms);
        for(Chromosom chrom : chromosoms){
            double functionResult = geneticFunction.getFunctionResult(chrom.getChromosomValue());
            if(functionResult < geneticFunction.getFunctionResult(theLowestChromosom.getChromosomValue()) && fulfilLimits(chrom.getChromosomValue()))
                theLowestChromosom = chrom;
        }
        return theLowestChromosom;
    }

}
