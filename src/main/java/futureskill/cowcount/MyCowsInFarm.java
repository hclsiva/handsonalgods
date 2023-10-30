package futureskill.cowcount;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyCowsInFarm implements APICaller{
    private int n = 0;
    int[][] farm = new int[n][n];
    public MyCowsInFarm(int n){
        this.n = n;
        farm = new int[n][n];
        List<Integer> cows = uniqueRandomElements(getNumberOfCows());
        int rem = 0;
        for(int i = 0; i < farm.length;i++){
            rem = (i%2);
            for(int j = 0; j < farm[0].length;j++){
                if((j + (i * getFieldSize()))%2 == 1 && cows.iterator().hasNext()) {
                    farm[i][j] = cows.iterator().next();
                    cows.remove(cows.iterator().next());
                }
            }

        }
    }
    public int getFieldSize(){
        return n;
    }
    public int getNumberOfCows(){
        return (n *n)/2;
    }
    public int getXCoordinateForCow(int x){
        for(int i = 0; i < farm.length;i++){
            for(int j = 0; j < farm[0].length;j++){
                if(farm[i][j] == x){
                    return i;
                }
            }
        }
        return 0;
    }
    public int getYCoordinateForCow(int x){
        for(int i = 0; i < farm.length;i++){
            for(int j = 0; j < farm[0].length;j++){
                if(farm[i][j] == x){
                    return j;
                }
            }
        }
        return 0;
    }
    public void printMatrix(){
        for(int i = 0; i < farm.length;i++){
            for(int j = 0; j < farm[0].length;j++){
                System.out.print("  "+farm[i][j]);
            }
            System.out.println();
        }
    }
    public static List<Integer> uniqueRandomElements(int size) {
        List<Integer> numbers = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers;
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        APICaller api = new MyCowsInFarm(6);
        api.printMatrix();
    }
}
