class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        int cnt = m;
        int[] map = new int[26], indices = new int[26];

        for (char c : tasks) map[c - 'A']++;

        int q = 0;

        while (cnt > 0) {
            int mx = -1, indx = -1;

            q++;

            for (int i = 0; i < 26; i++) {
                int prevIndx = indices[i], indxDiff = q - prevIndx;

                int f = map[i];

                if ((f > 0) && (f > mx)) {
                    if (prevIndx == 0) {
                        mx = f; indx = i;
                    } else if (indxDiff > n) {
                        mx = f; indx = i;
                    }
                }
            } 

            if (mx != -1) {
                indices[indx] = q; map[indx]--; cnt--;
            } 
        } 

        return q;
    }
}