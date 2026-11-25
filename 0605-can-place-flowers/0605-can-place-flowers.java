class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(len == 1){
            if(n>1)
               return false;
            if(flowerbed[0] == 1 && n == 1)
                return false;
            else 
            return true;
        }
        for(int i = 0; i < len-1; i++){
            if(n == 0)
              break;
            if(i==0 && flowerbed[1] == 0 && flowerbed[0] == 0){
                n--;
                flowerbed[0]=1;
            }
            else if(i != 0 && flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                n--;
                flowerbed[i] = 1;
            }
        }
        if(n !=0 && flowerbed[len-2] == 0 && flowerbed[len-1] == 0)
            n--;
        
        return n==0;
    }
}