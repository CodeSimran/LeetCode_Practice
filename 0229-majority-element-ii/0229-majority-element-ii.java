class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int count1 = 0;

        int candidate2 = 0;
        int count2 = 0;

        // First pass: Find possible candidates
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }
            else if(nums[i] == candidate2){
                count2++;
            }
            else if(count1 == 0 ){
                candidate1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        // Second pass: Count actual frequencies
        int freq1 = 0;
        int freq2 = 0;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == candidate1){
                freq1++;
            }
            if(nums[i] == candidate2){
                freq2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        // Verify the first candidate
        if(freq1 > nums.length/3){
            result.add(candidate1);
        }

        // Verify the second candidate and avoid duplicates
        if(freq2 > nums.length/3 && candidate2 != candidate1){
            result.add(candidate2);
        }

        return result;
    }
}