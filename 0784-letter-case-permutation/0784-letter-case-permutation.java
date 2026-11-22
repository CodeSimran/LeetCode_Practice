class Solution {
    public List<String> letterCasePermutation(String s) {
        char arr[] = s.toCharArray();
        List<String> ans = new ArrayList<>();
        solve(ans, arr, 0);
    return ans;
    }

    void solve(List<String> res, char str[], int pos){
        if(pos == str.length){
            res.add(new String(str));
            return;
        }

        if(Character.isLetter(str[pos])){
            if(Character.isUpperCase(str[pos])){
                str[pos] = Character.toLowerCase(str[pos]);
                solve(res, str, pos+1);
                str[pos] = Character.toUpperCase(str[pos]);
            }
            else{
                str[pos] = Character.toUpperCase(str[pos]);
                solve(res, str, pos+1);
                str[pos] = Character.toLowerCase(str[pos]);
            }
           
        }
        solve(res, str, pos+1);
    }
}