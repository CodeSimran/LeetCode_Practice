// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int[] nge = new int[nums.length];
//         Stack<Integer> st = new Stack<>();

//         st.push(0);
//         for(int i=1;i<nums.length;i++){
//             while(st.size() > 0 && nums[i] > nums[st.peek()]){
//                 int pos = st.peek();
//                 nge[pos] = nums[i];
//                 st.pop();
//             }
//             st.push(i);
//         }
//         while(st.size()>0){
//             int pos = st.peek();
//             nge[pos] = -1;
//             st.pop();
//         }
//         return nge;
        
//     }
// }



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