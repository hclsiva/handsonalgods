package leetcode.cheatsheet;

import futureskill.SilverTrading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import static java.lang.Math.*;

public class BestTimeToBuyStock {
    private int buyDay = 0;
    private int sellDay = 0;
    public int maxProfitLocalMin(int[] prices){
        if(prices == null){
            return 0;
        }
        int l =0; int r=1;
        int maxProfit = 0;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                if(prices[r]-prices[l] > maxProfit){
                    buyDay=l;
                    sellDay = r;
                    maxProfit = prices[r]-prices[l];
                }
            }else{
                l = r;
            }
            r+=1;
        }
        return maxProfit;
    }
    public int buyAndSell2(int[] prices){
        if(prices == null){
            return 0;
        }
        int l = 0; int r = 1;
        int totalProfit= 0;
        while(r < prices.length){
            if(prices[r] > prices[l]){
                totalProfit += prices[r]-prices[l];
            }
            l = r;
            r+=1;
        }
        return totalProfit;
    }
    public int buyAndSell3(int[] prices){
        if(prices == null || prices.length == 0){
            return 0;
        }
        int minPrice =Integer.MAX_VALUE;
        int profit= 0;
        int effectiveMinPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        int[] emp = new int[prices.length];
        for(int i =0; i < prices.length; i++){
            minPrice = min(minPrice,prices[i]);
            profit = max(profit, prices[i]-minPrice);
            effectiveMinPrice = min(effectiveMinPrice,prices[i]-profit);
            maxProfit=max(maxProfit,Math.abs(prices[i]-effectiveMinPrice));
            emp[i] = maxProfit;
        }
        return maxProfit;
    }
    private int maximizeProfit(int k, int[] prices){
        int[][] effectiveProfits = new int[k+1][prices.length];
        for(int i = 1; i < effectiveProfits.length; i++){
            int maxProfit = 0;
            for(int j = 1,l=1 ;j < effectiveProfits[0].length && l<prices.length ; j++,l++){
               maxProfit = max(maxProfit,findProfitForCurrentPrice(effectiveProfits,i,j,prices[l],prices));
               effectiveProfits[i][j] = maxProfit;
            }
        }
        print(effectiveProfits);
        System.out.println("---------------------------------------------");
        return effectiveProfits[effectiveProfits.length-1][effectiveProfits[0].length-1];
    }
    private int findProfitForCurrentPrice(int[][] ep,int row,int col,int currentPrice,int[] prices){
        int profit=0;
        for(int i = 1; i <= col; i++){
            profit = max(profit,currentPrice-prices[i-1]+ep[row-1][i-1]);
        }
        return profit;
    }
    private void print(int[][] e){
        for(int i = 0; i < e.length; i++){
            for(int j = 0;j < e[0].length; j++){
                System.out.print(e[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BestTimeToBuyStock timeToBuy = new BestTimeToBuyStock();
        int[] intPrices = null;
        int maxProfit = 0;
        //intPrices = IntStream.of(7, 12, 5, 3, 11, 6, 10, 2, 9).toArray();
        //maxProfit = timeToBuy.maxProfitLocalMin(intPrices);
        /*
        Path path = Paths.get("prices.in");
        String line = null;
        try {
            line = Files.readAllLines(path).get(0);
            String[] prices = line.split(",");
            intPrices = Arrays.stream(prices).mapToInt(Integer::parseInt).toArray();
            maxProfit = timeToBuy.maxProfitLocalMin(intPrices);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Buy Day = " + timeToBuy.buyDay + " Sell Day = " + timeToBuy.sellDay + " profit = " + maxProfit);

        System.out.println(timeToBuy.buyAndSell2(IntStream.of(7,1,5,3,6,4).toArray()));
        System.out.println(timeToBuy.buyAndSell2(IntStream.of(1,2,3,4,5).toArray()));
        System.out.println(timeToBuy.buyAndSell2(IntStream.of(7,6,4,3,1).toArray()));

         */
        // System.out.println(timeToBuy.buyAndSell3(IntStream.of(3,3,5,0,0,3,1,4).toArray()));
        // System.out.println(timeToBuy.buyAndSell2(IntStream.of(1,2,3,4,5).toArray()));
        // System.out.println(timeToBuy.buyAndSell2(IntStream.of(7,6,4,3,1).toArray()));
         System.out.println(timeToBuy.maximizeProfit(2,IntStream.of(3,3,5,0,0,3,1,4).toArray()));
        //System.out.println(timeToBuy.maximizeProfit(3,IntStream.of(3,2,6,5,0,3,2,6).toArray()));
    }
}
