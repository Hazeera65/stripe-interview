// class Solution {
//      int price =Integer.MAX_VALUE;
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       
//       check(flights,src,dst,k+1,0);
//         return price == Integer.MAX_VALUE ? -1 : price;
//     }
//     public void check(int[][] flights,int src,int dst,int k,int cost){
//         if(k<0){
//             return;
//         }
//         if(cost>=price){
//             return;
//         }
//         if(src==dst){
//             price =Math.min(cost,price);
//             return;
//         }
//         for(int i=0;i<flights.length;i++){
//             if(src==flights[i][0]){
//             int next =flights[i][1];
//             int o=flights[i][2];
//             check(flights,next,dst,k-1,cost+o);
//             }
//         }

//     }
// }
import java.util.*;
class Solution {

    int price = Integer.MAX_VALUE;
    HashMap<String, Integer> memo = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        check(flights, src, dst, k + 1, 0);
        return price == Integer.MAX_VALUE ? -1 : price;
    }

    public void check(int[][] flights, int src, int dst, int k, int cost) {

        if (k < 0) return;
        if (cost >= price) return;

        String key = src + "-" + k;

        
        if (memo.containsKey(key) && memo.get(key) <= cost) {
            return;
        }
        memo.put(key, cost);

        if (src == dst) {
            price = Math.min(price, cost);
            return;
        }

        for (int i = 0; i < flights.length; i++) {
            if (src == flights[i][0]) {
                check(flights, flights[i][1], dst, k - 1, cost + flights[i][2]);
            }
        }
    }
}
