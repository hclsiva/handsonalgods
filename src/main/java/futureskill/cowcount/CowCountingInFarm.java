package futureskill.cowcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CowCountingInFarm {
    private APICaller api = null;
    private boolean[] cowArray = null;
    public CowCountingInFarm(int farmSize){
        api = new MyCowsInFarm(farmSize);
        api.printMatrix();
        init();
    }
    private void init(){
        cowArray = new boolean[api.getFieldSize()* api.getFieldSize()];
        Arrays.fill(cowArray,false);
        for(int i = 1;i <= api.getNumberOfCows();i++){
            int x = api.getXCoordinateForCow(i);
            int y = api.getYCoordinateForCow(i);
            int idx = (x*api.getFieldSize()) + y;
            cowArray[idx] = true;
        }
    }

    private List<Integer> getNeighbours(int x, int y){
        if(api.getFieldSize() == 1)
            return new ArrayList();
        List<Integer> neighbors = new ArrayList<Integer>();
        int idx = (x*api.getFieldSize()) + y;

        if(x == 0){
            neighbors.add(idx+api.getFieldSize());
        }else if(x == (api.getFieldSize() -1)){
            neighbors.add(idx-api.getFieldSize());
        }   else    {
            neighbors.add(idx-api.getFieldSize());
            neighbors.add(idx+api.getFieldSize());
        }


        if(y == 0){
            neighbors.add(idx+1);
        }else if(y == (api.getFieldSize() -1)){
            neighbors.add(idx-1);
        }else{
            neighbors.add(idx-1);
            neighbors.add(idx+1);
        }


        return neighbors;
    }
    public int getNumberOfCowsInCorners(){
        if(api.getFieldSize() == 1)
            return api.getNumberOfCows();
       long count = IntStream.of(
                0,
                api.getFieldSize()-1,
               (api.getFieldSize()-1) * api.getFieldSize(),
                (api.getFieldSize()* api.getFieldSize())-1
        ).filter((k) -> k >=0 && k < cowArray.length && cowArray[k] == true ).count();
        return Long.valueOf(count).intValue();
    }
    public int getNumberOfCowsWithNeighbours(){
        int x =0, y=0;
        long count = 0;
        List<Integer> neighbors = null;
        for(int i =1; i < api.getNumberOfCows();i++){
            x = api.getXCoordinateForCow(i);
            y = api.getYCoordinateForCow(i);
            neighbors = this.getNeighbours(x,y);
            long tmp =neighbors.stream().filter(j -> j >= 0 && j < cowArray.length && cowArray[j] == true).count();
            count += tmp;
        }
        return Long.valueOf(count).intValue();
    }

    public static void main(String[] args) {
        CowCountingInFarm cc = new CowCountingInFarm(10);
        System.out.println("Number of cows in corner = " +cc.getNumberOfCowsInCorners() + " Number of cows with Neighbors = " + cc.getNumberOfCowsWithNeighbours());
    }
}
