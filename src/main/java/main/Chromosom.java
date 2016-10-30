package main;

import util.Rounder;

/**
 * Created by Maciek on 2016-10-26.
 */
public class Chromosom implements Comparable {

    private int [] chrom_bits;

    private static int instanceCounter = 0;

    private int counter = 0;

    public Chromosom(int [] chrom_bits){
        instanceCounter++;
        counter = instanceCounter;
        this.chrom_bits = chrom_bits;
    }

    public int [] getChromBits(){
        return chrom_bits;
    }

    public void setChromBits(int [] bits) {
         this.chrom_bits = bits;
    }

    public double getChromosomValue(){
        return Rounder.round(Operations.changeBitsIntoDoubleValue(chrom_bits), 2);
    }

    public int compareTo(Object chromosom) {
        if(this.getChromosomValue() > ((Chromosom)chromosom).getChromosomValue())
            return 1;
        else if(this.getChromosomValue() < ((Chromosom)chromosom).getChromosomValue())
            return -1;
        else
            return 0;
    }

    public int getId(){
        return counter;
    }

}
