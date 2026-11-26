class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] t = new int[1002];

        for(int[] x : trips) {
            t[x[1]] += x[0];
            t[x[2]] -= x[0];
        }

        int sum = 0;

        for(int i=0; i<t.length; i++) {
            sum += t[i];
            if(sum > capacity) return false;
        }
        return true;
    }
}