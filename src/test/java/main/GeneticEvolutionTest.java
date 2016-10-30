package main;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maciek on 2016-10-27.
 */
public class GeneticEvolutionTest {

    private static final int min = -40;

    private static final int max = 40;

    private static final int population_size = 100;

    private int[] functionParameters = {-7, -2, 2, 3, 4};

    private GeneticEvolution geneticEvolution;

    private Function geneticFunction;

    private List<Chromosom> testChromes;

    private List<Chromosom> generateTestChromes(){
        Operations operations = new Operations(min, max);
        double[] randomNumbers = operations.getRandomNumbers(population_size);
        List<Chromosom> chromosoms = operations.generatePopulation(randomNumbers);
        return chromosoms;
    }

    @Before
    public void initalize() {
        geneticEvolution = new GeneticEvolution(functionParameters, min, max);
        testChromes = generateTestChromes();

        geneticFunction = new Function(functionParameters);

    }

    /*@Test
    public void mutationTest() {
        for(Chromosom chromosom : testChromes){
            geneticEvolution.mutate(chromosom);
            //System.out.println("Print each chromosom : " + chromosom.getChromosomValue());
        }
    }

    @Test
    public void populationIterationTest() {
        //given
        List<Chromosom> chromsAfterIteration = geneticEvolution.populationIteration(testChromes);

        //then
        for (Chromosom chromosom : chromsAfterIteration){
            System.out.println("Population Chrom : " + chromosom.getChromosomValue());
            for(int i = 0  ; i < chromosom.getChromBits().length; i++){
                System.out.print(" " + chromosom.getChromBits()[i]);
            }
            System.out.println();
        }
        System.out.println("POpulation size : " + chromsAfterIteration.size());
    }

    @Test
    public void genereteRandomChromosomesTest() {
        //given
        List<Chromosom> chromosoms = geneticEvolution.generateRandomChromosoms(40);
        //then
        assertEquals(chromosoms.size(), 40, 0);

        for (Chromosom chromosom : chromosoms){
            assertEquals(chromosom.getChromosomValue() >= min && chromosom.getChromosomValue() <= max, true);
        }
    }*/

    /*@Test
    public void getTheBestChromosoms() {
        //given
        int lowerLimit = 10;
        int upperLimit = 25;
        //when
        List<Chromosom> charactersBetween = geneticEvolution.getBestCharactersBetween(generateTestChromes(), lowerLimit, upperLimit);
        //then
        assertEquals((upperLimit - lowerLimit) + 1, charactersBetween.size(), 0);
            //make sure that last element is higher that the first one.
        assertEquals(geneticFunction.getFunctionResult(charactersBetween.get(0).getChromosomValue()) <
                     geneticFunction.getFunctionResult(charactersBetween.get(charactersBetween.size() - 1).getChromosomValue()), true);
    }

    @Test
    public void populationIterationTest(){
        //when
        List<Chromosom> survivedChromosomes = geneticEvolution.populationIteration(generateTestChromes());
        //then
        assertEquals(survivedChromosomes.size(), 50, 0);
    }*/


    @Test
    public void getMasterChromTest(){
        //when
        Chromosom masterChrom = geneticEvolution.getMasterChrom(generateTestChromes());

        //then
        System.out.println("Master hrom value : " +  masterChrom.getChromosomValue());
    }

    /*@Test
    public void findTheBestCharacterTest(){
        //given
        List<Chromosom> testChromoes = generateTestChromes();

        //when
        Chromosom theBestCharacter = geneticEvolution.findTheBestCharacter(testChromoes);
        for(Chromosom chromosom : testChromoes){
            System.out.println("Test chrom : " + chromosom.getChromosomValue());
        }

        System.out.println("The best character value : " + theBestCharacter.getChromosomValue());
    }*/


}
