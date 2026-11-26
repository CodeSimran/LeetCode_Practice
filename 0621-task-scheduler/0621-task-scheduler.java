class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            freq[task-'A']++;
            if(max==freq[task-'A']) {
                maxCount++;
            }
            else if(max < freq[task -'A']) {
                max = freq[task-'A'];
                maxCount = 1;
            }
        }

        int gapCount = max - 1;
        int gapLength = n -(maxCount - 1);
        int empty = gapCount * gapLength;
        int availableTasks = tasks.length - max*maxCount;
        int idles = Math.max(0, empty - availableTasks);

        return tasks.length+idles;
    }
}