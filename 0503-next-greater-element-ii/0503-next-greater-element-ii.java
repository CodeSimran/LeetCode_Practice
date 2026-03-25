class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];

        // Manually initialize with -1
        for(int i = 0; i < n; i++){
            nge[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < 2 * n; i++){
            int idx = i % n;

            while(!st.isEmpty() && nums[idx] > nums[st.peek()]){
                nge[st.peek()] = nums[idx];
                st.pop();
            }

            if(i < n){
                st.push(idx);
            }
        }

        return nge;
    }
}