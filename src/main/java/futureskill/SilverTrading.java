package futureskill;

import java.util.stream.IntStream;
public class SilverTrading {
    private int buyDay =0;
    private int sellDay = 0;
    public static void main(String[] args){
        SilverTrading trading = new SilverTrading();
        int[] intPrices = null;
        intPrices = IntStream.of(7,12,5,3,11,6,10,2,9).toArray();
        trading.calculateMaxProfit(intPrices);
        //System.out.println(trading.calculateMaxProfit(intPrices));
        /*Path path = Paths.get("prices.in");
        String line = null;
        try {
            line = Files.readAllLines(path).get(0);
            String[] prices = line.split(",");
            intPrices = Arrays.stream(prices).mapToInt(Integer::parseInt).toArray();
            trading.calculateMaxProfit(intPrices);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("Buy Day = " + trading.buyDay + " Sell Day = " + trading.sellDay + " profit = " + (intPrices[trading.sellDay] - intPrices[trading.buyDay]));
    }
    public int calculateMaxProfit(int[] arr) {

        int buyPrice =Integer.MAX_VALUE;
        int profit = 0;
        for(int i =0; i < arr.length; i++){
            if(arr[i]  < buyPrice ) {
                buyPrice = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (profit < (arr[j] - buyPrice)) {
                        this.buyDay = i;
                        this.sellDay = j;
                        profit = arr[j] - buyPrice;
                    }
                }
            }
        }
        return profit;
    }
}
