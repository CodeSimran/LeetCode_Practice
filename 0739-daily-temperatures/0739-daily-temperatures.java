class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> ans = new Stack<>();

        int n = temperatures.length;
        int[] res = new int[n];

        for(int idx = n-1;idx>=0;idx--){
            while(!ans.isEmpty() && temperatures[idx]>=temperatures[ans.peek()]){
                ans.pop();
            }

            if(!ans.isEmpty()){
                res[idx] = ans.peek() - idx;
            }
            ans.push(idx);
        }
        return res;
    }
}