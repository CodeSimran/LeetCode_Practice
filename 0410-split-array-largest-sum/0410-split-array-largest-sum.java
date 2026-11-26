class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int l = Integer.MIN_VALUE, r = 0;

        for(int el : nums){
            l = Math.max(el, l);
            r += el;
        }

        while(l <= r){
            int m = l + (r - l) / 2;

            boolean ans = canSplit(nums, k, m);
            if(ans) r = m - 1;
            else l = m + 1;
        }

        return l;

    }

    public boolean canSplit(int[] nums, int k, int m){
        int sum = 0, subarray = 1;

        for(int el : nums){
            
            if(sum + el > m){
                sum = el;
                subarray++;
            } else sum += el;
            if(subarray > k) return false;
        }

        return true;
    }
}