class Solution {
    public int wiggleMaxLength(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        int[] up = new int[size];
        int[] down = new int[size];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < size; ++i) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[size - 1], down[size - 1]);
    }
}