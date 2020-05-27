import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                profit = Math.max(profit, prices[j]-prices[i]);
            }
        }
        return profit;
    }

    public static void main(final String... args) {
        int[] c1 = new int[]{7,1,5,3,6,4};
        int r1 = maxProfit(c1);
        // output : 5
        System.out.println(r1);

        int[] c2 = new int[]{10,9,8,7,6,5,4,3,2,1};
        int r2 = maxProfit(c2);
        // output : 0
        System.out.println(r2);

        int[] c3 = new int[4];
        int r3 = maxProfit(c3);
        System.out.println(r3);
    }
}