class Solution {
    public boolean isNumber(String s) {
        boolean number = false , exp = false, dotseen = false;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if('0' <= ch && ch<='9'){
                number = true;
            }
            else if(ch == '.'){
                if(dotseen || exp){
                    return false;
                }
                dotseen = true;
            }
            else if(ch == 'e' || ch == 'E'){
                if(exp || !number){
                    return false;
                }
                exp = true;
                number = false;
            }
            else if(ch == '+' || ch =='-'){
                if(i>0 && s.charAt(i-1) !='e' && s.charAt(i-1) !='E'){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return number;
    }
}