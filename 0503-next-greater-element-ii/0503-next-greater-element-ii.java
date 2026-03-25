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
        Arrays.fill(nge, -1); // default = -1

        Stack<Integer> st = new Stack<>();

        // Traverse twice for circular behavior
        for(int i = 0; i < 2 * n; i++){
            int idx = i % n;

            while(!st.isEmpty() && nums[idx] > nums[st.peek()]){
                nge[st.peek()] = nums[idx];
                st.pop();
            }

            // Only push in first pass
            if(i < n){
                st.push(idx);
            }
        }

        return nge;
    }
}