class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    //     HashMap<String,List<String>> hm = new HashMap<>();
    // for(int i=0;i<strs.length;i++){
    //     char[] ch = strs[i].toCharArray();
    //     Arrays.sort(ch);
    //     String sorted = new String(ch);
    //     if(!hm.containsKey(sorted)){
    //         hm.put(sorted,new ArrayList<String>());
    //     }
    //     hm.get(sorted).add(strs[i]);
    // }
    // return new ArrayList<List<String>>(hm.values());
    // }

         Map<String,List> map = new HashMap<>();
         for(String s : strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb  = new StringBuilder();
            for(int i : count){
                sb.append("#");
                sb.append(i);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(s);
         }
         return new ArrayList(map.values());

    }
}