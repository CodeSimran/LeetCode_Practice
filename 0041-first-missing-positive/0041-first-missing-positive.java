
class Solution {
    public int firstMissingPositive(int[] nums) {
    int n=nums.length;
    for(int i=0; i<n; i++){
        if(nums[i] <= 0  ||  nums[i] > n){
            nums[i]=n + 1;
        }
    }
    for(int i=0; i<n; i++){
        int element=Math.abs(nums[i]);
        if(element == n + 1){
            continue;
        }
        if(nums[element - 1] < 0){
            continue;
        }
        nums[element -1]= -nums[element - 1];
    }
    for(int i=0; i<n; i++){
        if(nums[i] > 0){
            return i + 1;
        }
    }
    return n + 1;
    }
}