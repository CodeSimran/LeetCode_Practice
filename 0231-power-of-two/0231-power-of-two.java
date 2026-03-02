class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        for(int i=0;i<31;i++){
            if(((int)Math.pow(2,i)==n)) return true;
        }
        return false;
        
    }
}