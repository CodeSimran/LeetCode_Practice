class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int id=0;
            long prd = 1;
            int left=0,right=potions.length-1;
            if((long)potions[potions.length-1]*(long)spells[i]<success){
                res[i]=0;
            }else{
                while(left<=right){
                    int mid = left + (right-left)/2;
                    prd = potions[mid];
                    if(prd*spells[i]>=success){
                        id=mid;
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
                res[i]=potions.length-id;
            }

        }
        return res;
        
    }
}