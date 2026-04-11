class Solution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for(int i=0;i<size;i++){
            if(!(nums[i]>0 && nums[i]<=size)){
                nums[i] = size+1;
            }
        }
        for(int i=0;i<size;i++){
            int curr = Math.abs(nums[i]);
            if(curr<=size){
                nums[curr-1] = -(Math.abs(nums[curr-1]));
            }
        }
       for(int i=0;i<size;i++){
        if(nums[i]>0){
            return i+1;
        }
       }
       return size+1;
        
    }
}