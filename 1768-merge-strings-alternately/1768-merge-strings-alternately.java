class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        char[] res = new char[n1+n2];

        int idx = 0;
        int maxlen = Math.max(n1,n2);
        for(int i=0;i<maxlen;i++){
            if(i<n1){
                res[idx++] = word1.charAt(i);
            }
            if(i<n2){
                res[idx++] = word2.charAt(i);
            }
        }
        return new String(res);
    }
}