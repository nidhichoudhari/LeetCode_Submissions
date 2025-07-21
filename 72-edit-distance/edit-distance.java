class Solution {
    public int minDistance(String word1, String word2) {
        //return rec(word1, word2, word1.length()-1, word2.length()-1);

        //topDowm
        //    int [][] dp = new int[word1.length()+1][word2.length()+1];
        //    for(int [] a : dp){
        //     Arrays.fill(a, -1);
        //    }
        //    return memo(word1, word2, word1.length()-1, word2.length()-1, dp);

        //bottom up 
        return bottom(word1, word2);
    }

    int rec(String s, String t, int n, int m) {
        if (n < 0) {
            return m + 1;
        }
        if (m < 0) {
            return n + 1;
        }

        int ans = 0;
        if (s.charAt(n) != t.charAt(m)) {
            int i = rec(s, t, n, m - 1);
            int d = rec(s, t, n - 1, m);
            int r = rec(s, t, n - 1, m - 1);
            ans = Math.min(Math.min(i, d), r) + 1;
        } else {
            ans = rec(s, t, n - 1, m - 1);
        }
        return ans;
    }

    int memo(String s, String t, int n, int m, int[][] dp) {
        if (n < 0) {
            return m + 1;
        }
        if (m < 0) {
            return n + 1;
        }

        if (dp[n][m] != -1)
            return dp[n][m];
        int ans = 0;
        if (s.charAt(n) != t.charAt(m)) {
            int i = rec(s, t, n, m - 1);
            int d = rec(s, t, n - 1, m);
            int r = rec(s, t, n - 1, m - 1);
            ans = Math.min(Math.min(i, d), r) + 1;
        } else {
            ans = rec(s, t, n - 1, m - 1);
        }
        return dp[n][m] = ans;
    }

    int bottom(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int I = dp[i][j - 1];
                    int D = dp[i - 1][j];
                    int R = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(I, D), R) + 1;
                }
            }
        }
        return dp[n][m];
    }
}