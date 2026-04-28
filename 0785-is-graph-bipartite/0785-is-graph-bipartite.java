class Solution {
   
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        char[] set = new char[n];

        for(int i=0;i<n;i++){
                if(set[i] == 0){
                if(!bfs(i , set ,graph)) return false;
                }
        }

        return true;
    }

    public boolean bfs(int i , char[] set ,int[][] graph){
        if(set[i] == 0) set[i] = 'A';

        Queue<Integer> q = new LinkedList<>();

        q.add(i);
        while(q.size() > 0){
            int vertex = q.poll();

            for(int j=0;j<graph[vertex].length;j++){
                if(set[graph[vertex][j]] == 0 && set[vertex] == 'A'){
                    set[graph[vertex][j]] = 'B';
                    q.add(graph[vertex][j]);
                }
                else if(set[graph[vertex][j]] == 0 && set[vertex] == 'B'){
                    set[graph[vertex][j]] = 'A';
                    q.add(graph[vertex][j]);
                }
                else if(set[graph[vertex][j]] != 0 && set[vertex] == set[graph[vertex][j]])return false;
            }
        }
        return true;
    }
}