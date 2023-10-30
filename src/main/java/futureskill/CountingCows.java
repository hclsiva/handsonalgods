package futureskill;

import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
public class CountingCows {

    Map<Integer,BigInteger> countMap = new HashMap<Integer,BigInteger>();
    public int solution(int years,int cows,int calves){
        for (int i = 0; i < years; i++) {
            int t = cows;
            cows += calves;
            calves = t;
            System.out.println("Years = "+(i+1) + " cows = " + cows + " Calves = " + calves);
        }
        return cows;
    }
    public BigInteger numberOfCows(int ages) {
        BigInteger v = countMap.getOrDefault(ages,null);
        if(v != null){
            return v;
        }
        BigInteger count = BigInteger.valueOf(1L);
        for (int year = 2; year <= ages; year++) {
            count = count.add(numberOfCows(ages - year));
        }
        countMap.putIfAbsent(ages,count);
        System.out.println("Year  = " + ages + " Total No Of Cows = " + count);
        return count;
    }
    public static void main(String ... args){
        CountingCows cc = new CountingCows();
        //cc.solution(5,1,0);

        cc.numberOfCows(20);
    }
}
