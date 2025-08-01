class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;   
        int [] count = new int[n*n+1];
        int [] ans = new int [2];

        for(int [] row:grid){
            for(int num:row){
                if(count[num]!=0){
                    ans[0]=num; // repeated
                }
                else{
                    count[num]++;
                }
            }
        }
        for(int i=1;i<count.length;i++){
            if(count[i]==0){
                ans[1]=i;// missing
                break;
            }
        }


        return ans;
    }
}