class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int left = 0;
        int currsum = 0;
        for(int right =0;right<nums.length;right++){
            currsum +=nums[right];

            while(currsum>=target){
                if(right - left +1 < len){
                    len = right - left +1;
                }
                currsum -= nums[left];
                left++;
            }
        }
        return len != Integer.MAX_VALUE ?len :0;
    }
}