class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i = 0 ; i < bills.length ; i++){
            if(bills[i] == 5) five++;
            else if(bills[i] == 10){
                ten++;
                if(five == 0) return false;
                five--;
            }
            else{
                if(five == 0) return false;
                else if(ten == 0){
                    if(five < 3) return false;
                    five -= 3;
                }
                else{
                    five--;
                    ten--;
                }
            }
        }
        return true;
    }
}

// five = 4
// ten = 0