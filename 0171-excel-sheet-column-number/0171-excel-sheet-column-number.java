class Solution {
    public int titleToNumber(String columnTitle) {
        // int res = 0;
        // String s = columnTitle;
        // for(int i=0;i<s.length();i++){
        //     res = res*26 +(s.charAt(i)-'A'+1);
        // }
        // return res;

        int res = 0;
        String s = columnTitle;
        for(int i=0;i<s.length();i++){
            res = res * 26 +(s.charAt(i) -'A'+1);
        }
        return res; 
    }
}