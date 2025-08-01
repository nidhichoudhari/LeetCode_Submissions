class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int n = grid.length;
        int sqr = n*n;
        int curSum = 0;
        int ans[] = new int[2];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                }else{
                    set.add(grid[i][j]);
                    curSum += grid[i][j];
                }
            }
        }

        int totalSum = sqr * (sqr+1)/2;
        ans[1] = totalSum - curSum;
        return ans;
    }
}