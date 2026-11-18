class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] range = new boolean[n+1];

        for(int num:nums){
            range[num]=true;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!range[i]){
                list.add(i);
            }
        }
        return list;
    }
}