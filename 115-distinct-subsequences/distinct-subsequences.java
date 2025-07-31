
class Solution {

    int fun(int ind1, int ind2, String s, String t, int dp[][]){
        
        if(ind2<0){
            return 1;
        }
        if(ind1<0) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        int take = 0;
        if(s.charAt(ind1)==t.charAt(ind2)){
            take = fun(ind1-1,ind2-1,s,t,dp);
        }
        int notTake = fun(ind1-1,ind2,s,t,dp);

        return dp[ind1][ind2] = (take+notTake);
    }
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();


        int dp[][] = new int[n+1][m+1];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return fun(n-1,m-1,s,t,dp);

    }
}