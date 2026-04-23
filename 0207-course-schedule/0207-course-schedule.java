class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> k = new ArrayList<>();
        int[] sub = new int[numCourses];

        for(int i = 0; i < sub.length; i++)
            k.add(new ArrayList<>());

        for(int[] i : prerequisites)
            k.get(i[1]).add(i[0]);

        for(int i = 0; i < sub.length; i++){
            if(sub[i] == 0 && val(k, sub, i))
                return false;
        }
        return true;
    }

    public boolean val(List<List<Integer>> k, int[] sub, int i){
        if(sub[i] == 1)
            return true;

        if(sub[i] == 2)
            return false;

        sub[i] = 1;

        for(int j : k.get(i))
            if(val(k, sub, j))
                return true;

        sub[i] = 2;
        return false;
    }
}