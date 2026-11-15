class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || x!=0 && x%10==0) return false;
        int rev =0;
        int rem =0;
        int x1=x;
        while(x!=0){
            rem = x%10;
            rev = (rev*10)+rem;
            x = x/10;
        }
        return rev==x1?true:false;
    }
}

