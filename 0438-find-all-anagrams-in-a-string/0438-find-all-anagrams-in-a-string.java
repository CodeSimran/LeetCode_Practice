class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int left = 0;
        int right = 0;
        int i =0;
        List<Integer> rlist = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];

        if(k>s.length()) return rlist;

        for(i=0;i<k;i++){
            pArr[p.charAt(i) - 'a']++;
        }
        for(right=0;right<s.length();right++){
            if(right-left+1 > k){
                sArr[s.charAt(left) - 'a']--;
                left++;
            }
            sArr[s.charAt(right)-'a']++;

            if(right-left+1 == k){
                if(Arrays.equals(sArr,pArr))
                rlist.add(left);
            }
        }
        return rlist;
        
    }
}