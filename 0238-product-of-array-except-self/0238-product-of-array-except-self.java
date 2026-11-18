class Solution {
    public int[] productExceptSelf(int[] nums) {
    int numslength = nums.length;
    int prefixProduct = 1;
    int suffixProduct = 1;
    int[] res = new int[numslength];
    for(int i =0;i<numslength;i++){
        res[i] = prefixProduct;
        prefixProduct *= nums[i];
    }
    for(int i = numslength-1;i>=0;i--){
        res[i] *= suffixProduct;
        suffixProduct *= nums[i];
    }
    return res;
    }
}