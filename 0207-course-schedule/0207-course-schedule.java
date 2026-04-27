class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());

        for(int[] p: prerequisites){
            graph.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i] == 0) q.add(i);

            int count =0;
            while(!q.isEmpty()){
                int course = q.poll();
                count++;
                for(int next : graph.get(course))
                    if(--inDegree[next]==0) q.add(next);
            }

        return count == numCourses;
        
    }
}