package dk.nydt.utils;

import dk.nydt.Fisk;

import java.util.ArrayList;
import java.util.Random;

public class RandomPrize {

    private Prize prizeWon;



    public RandomPrize(){
        ArrayList<Prize> prizes = Fisk.rc.getPrizes();
        float[] chanceTable = generateChanceTable(prizes);
        Random random = new Random();
        float randomNum = (float) random.nextInt(10100) / 100;
        if(randomNum > 100f) randomNum = 100f;
        for(int n = prizes.size()-1; n >= 0; n--){
            if(randomNum < chanceTable[n])
                this.prizeWon = prizes.get(n);

        }
    }


    private float[] generateChanceTable(ArrayList<Prize> prizes){
        float[] prizesChances = new float[prizes.size()];
        int y = 0;
        for(Prize prize : prizes){
            prizesChances[y] = prize.getChance();
            y++;
        }

        float[] chanceTable = new float[prizes.size()];
        int x = 0;
        float n = 0f;
        for(float chance : prizesChances){
            n+= chance;
            chanceTable[x] = n;
            x++;
        }
        return chanceTable;
    }

    public Prize getPrize(){
        return this.prizeWon;
    }

}
