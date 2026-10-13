class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
    LinkedList<Integer> inc = new LinkedList<>();
    LinkedList<Integer> dec = new LinkedList<>();

    int max = 0;
    int left = 0;

    for(int i =0;i<nums.length;i++){
     int n = nums[i];

     while(inc.size() > 0 && n<inc.getLast()){
        inc.removeLast();
     }
     inc.add(n);
     while(dec.size()>0 && n>dec.getLast()){
        dec.removeLast();
     }
     dec.add(n);

     while(dec.getFirst() - inc.getFirst() > limit){
        if(nums[left] == dec.getFirst()){
            dec.removeFirst();
        }
        if(nums[left] == inc.getFirst()){
            inc.removeFirst();
        }
        left++;
     }
     int size = i-left +1;
     max = Math.max(max,size);
    }
    return max;



    }
}