class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis=new boolean[n];

        return dfs(graph,vis,source,destination);
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int src,int tar){
        if(src==tar)
        return true;

        vis[src]=true;

        for(int neigh:graph.get(src)){
            if(!vis[neigh]){
            boolean an= dfs(graph,vis,neigh,tar);
            if(an)
            return true;
            }
        }

        return false;
    }
}