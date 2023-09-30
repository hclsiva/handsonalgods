package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        Map<Integer, Integer> changeMap = new HashMap<>();
        int tempAmount = amount;
        int coinIndex = coins.length-1;
        while(tempAmount>0 && coinIndex >=0){
            while(tempAmount >= coins[coinIndex]){
                int coinsRequired = tempAmount / coins[coinIndex];
                tempAmount = tempAmount % coins[coinIndex];
                updateCoinChange(coins[coinIndex],coinsRequired,changeMap);
            }
            coinIndex--;
        }
        return (tempAmount == 0)?((changeMap.size() >0 )?changeMap.values().stream().mapToInt((Integer::intValue)).sum():0):-1;
    }
    private void updateCoinChange(Integer coin, Integer freq, Map<Integer,Integer> changeMap){
        changeMap.putIfAbsent(coin,0);
        changeMap.put(coin,changeMap.get(coin)+freq);
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(IntStream.of(186,419,83,408).toArray(),6249));
    }

}
