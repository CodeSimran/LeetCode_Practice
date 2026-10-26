class Solution {
    private int f(ArrayList<Integer> nums , int i , int j,int dp[][]){
    if(i>j) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    int maxi = Integer.MIN_VALUE;
    for(int idx = i ; idx<=j;idx++){
        int cost  = nums.get(i-1)*nums.get(idx)*nums.get(j+1) + f(nums,i,idx-1,dp)+f(nums,idx+1,j,dp);
        maxi = Math.max(maxi,cost);
        
    }
    return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        for(int it : nums){
            num.add(it);
        }
        num.add(1);
        int dp[][] = new int[n+1][n+1];
        for(int it[] : dp){
            Arrays.fill(it,-1);
        }
        return f(num,1,n,dp);

    }
}