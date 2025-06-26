import java.util.Arrays;

public class Solution {
    public static int[] maxDif(int[] prices) {
        //initiated indices for buy/sell prices of max profit
        int[] maxx = {0, 0};
        int low = 0; //tracking lowest number found

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[low]) {
                low = i;
            } else {
                int currentDiff = prices[i] - prices[low];
                int bestDiff = prices[maxx[1]] - prices[maxx[0]];
                if (currentDiff > bestDiff) {
                    maxx[0] = low;
                    maxx[1] = i;
                }
            }
        }
        return maxx;
    }


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 1) overall best buy/sell segment
        int[] best = Solution.maxDif(prices);
        int buy = best[0], sell = best[1];
        int maxHighM = prices[sell] - prices[buy];

        // 2) middle segment for max drop
        int[] mArr = Arrays.copyOfRange(prices, buy, sell + 1);
        int maxDropM = 0;
        if (mArr.length > 1) {
            // invert the values to find the largest drop
            int[] neg = new int[mArr.length];
            for (int i = 0; i < mArr.length; i++) {
                neg[i] = -mArr[i];
            }
            int[] dropIdx = Solution.maxDif(neg);
            // drop = original mArr[dropStart] - mArr[dropEnd]
            maxDropM = mArr[dropIdx[0]] - mArr[dropIdx[1]];
        }

        // 3) left segment before the overall buy
        int[] lArr = (buy > 0) ? Arrays.copyOfRange(prices, 0, buy) : new int[0];
        int maxHighL = 0;
        if (lArr.length > 1) {
            int[] idxL = Solution.maxDif(lArr);
            maxHighL = lArr[idxL[1]] - lArr[idxL[0]];
        }

        // 4) right segment after the overall sell
        int[] rArr = (sell + 1 < prices.length)
            ? Arrays.copyOfRange(prices, sell + 1, prices.length)
            : new int[0];
        int maxHighR = 0;
        if (rArr.length > 1) {
            int[] idxR = Solution.maxDif(rArr);
            maxHighR = rArr[idxR[1]] - rArr[idxR[0]];
        }

        // total best = best of (left, drop in mid, right) + the main profit
        return Math.max(Math.max(maxHighL, maxDropM), maxHighR) + maxHighM;
    }
}