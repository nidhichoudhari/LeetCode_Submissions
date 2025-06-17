class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[] ax=new int[m];
        int[] ay=new int[n];
        Map<Integer,Pair<Integer,Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mp.put(mat[i][j],new Pair(i,j));
            }
        }
        int mx=0,my=0;
        for(int i=0;i<arr.length;i++){
            Pair<Integer,Integer> p = mp.get(arr[i]);
            int x=p.getKey();
            int y=p.getValue();
            ax[y]++;ay[x]++;
            mx=Math.max(mx,ax[y]);
            my=Math.max(my,ay[x]);
            if(mx==n)return i;
            if(my==m)return i;
        }
        return 0;
    }

}