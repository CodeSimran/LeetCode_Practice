class Solution {
    public boolean dfs(int node,int[][] graph,int [] vis ,int[] pathvis,int[] check){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(int j=0;j<graph[node].length;j++){
            if(vis[graph[node][j]]==0){
                if(dfs(graph[node][j],graph,vis,pathvis,check)==true){
                    return true;
                }
            }
            else if(pathvis[graph[node][j]]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        int[] vis= new int[n];
        int[] pathvis= new int[n];
        int[] check = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathvis,check);
            }
        } 
        List<Integer> safe = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) safe.add(i);
        }
        return safe;
    }
}