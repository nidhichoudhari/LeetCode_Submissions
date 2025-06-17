class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // simple hai -> start from a node (if it end's somewhere else other than og node)(i.e. no cycle) => It's an eventual safe state

        int m = graph.length; //number of nodes
        List<Integer> ans = new ArrayList<Integer>();
        int[] isSafe = new int[m];

        for(int i=0; i<m; i++){
            if(dfs(i, graph, isSafe)){
                ans.add(i);
            }
        }

        return ans;
    }
    static boolean dfs(int node, int[][] grid, int[] isSafe){

        if(isSafe[node] != 0) {
            return (isSafe[node] == 1) ? true : false;
        }

        isSafe[node] = -1;

        for(int ele : grid[node]){
            if(!dfs(ele, grid, isSafe)) {
                return false;
            }
        }
        // traversed all neighbours and none ret false
        isSafe[node] = 1;
        return true;
    }
}