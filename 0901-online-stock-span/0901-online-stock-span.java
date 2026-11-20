import java.util.*;

class StockSpanner {
    ArrayList<Integer> list = new ArrayList<>();
    public StockSpanner() {
        
    }

    public int next(int price) {

        list.add(price);
        int ans = 0;

        for(int i=list.size()-1; i>=0; i--){
            // System.out.println(list.get(i));
            if(price >= list.get(i)) ans++;
            else break;
        }

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */