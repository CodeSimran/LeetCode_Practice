class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result=new ArrayList<>();
        String current="";
        generateStringPermutation(0,current,s,result);
        
        return result;
    }
    public static void generateStringPermutation(int index,String current,String str,List<String> result){
        if(index==str.length()){
             result.add(current);
             return ;
        }
        
         if(Character.isDigit(str.charAt(index))){
            generateStringPermutation(index+1,current+str.charAt(index),str,result);
            return;
        }

            generateStringPermutation(index+1,current+str.charAt(index),str,result);
            char ch;
            if(Character.isUpperCase(str.charAt(index))){
                ch=Character.toLowerCase(str.charAt(index));
            }else{
                ch=Character.toUpperCase(str.charAt(index));
            }

            generateStringPermutation(index+1,current+ch,str,result);
        
    }
} 