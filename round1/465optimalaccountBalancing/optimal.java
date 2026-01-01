import java.util.*;

public class optimal {
    public static int check(int trans[][]){
        HashMap<Integer,Integer> k = new HashMap<>();
        for(int t[]:trans){
            k.put(t[0],k.getOrDefault(t[0],0)-t[2]);
             k.put(t[1],k.getOrDefault(t[1],0)+t[2]);
        }
             List<Integer>debit = new ArrayList<>();
             for(int x:k.values()){
                if(x!=0){
                    debit.add(x);
                }
             }
             return dfs(0,debit);

        }
        public static int dfs(int i,List<Integer> debit){
            if(i<debit.size() && debit.get(i)==0){
               i++;
            }
            if(i==debit.size()){
                return 0;
            }
            int min=Integer.MAX_VALUE;
            int curr =debit.get(i);
            for(int j=i+1;j<debit.size();j++){
                if(curr*debit.get(j)<0){
                    debit.set(j,curr+debit.get(j));
                    min=Integer.min(min,1+dfs(j+1,debit));
                   
                     debit.set(j,debit.get(j)-curr);
                     if(debit.get(j)+curr==0) break;
            
                }
            }
                return min;
            
        }
public static void main(String[] args){
    Scanner o = new Scanner(System.in);
    int u =o.nextInt();
    int trans[][] = new int[u][3];
    for(int i=0;i<u;i++){
        for(int j=0;j<3;j++){
            trans[i][j]=o.nextInt();
        }
    }
    System.out.println(check(trans));
}
}




// Test Case 4: Multiple Debtors → One Creditor

// Input

// [[0,2,5],[1,2,5]]


// Net balances

// 0: -5
// 1: -5
// 2: +10


// Output

// 2

// Test Case 5: One Debtor → Multiple Creditors

// Input

// [[0,1,5],[0,2,5]]


// Net balances

// 0: -10
// 1: +5
// 2: +5


// Output

// 2

// Test Case 6: Classic Optimization Case

// Input

// [[0,1,10],[2,0,5]]


// Net balances

// 0: -5
// 1: +10
// 2: -5


// Optimal Settlement

// 0 → 1 (5)
// 2 → 1 (5)


// Output

// 2

// Test Case 7: Zero-Balance People Ignored

// Input

// [[0,1,10],[2,3,5]]


// Net balances

// 0: -10
// 1: +10
// 2: -5
// 3: +5


// Output

// 2

// Test Case 8: Circular Debt (Key Insight Case)

// Input

// [[0,1,10],[1,2,10],[2,0,10]]


// Net balances

// 0: 0
// 1: 0
// 2: 0


// Output

// 0

// Test Case 9: Medium Complex Case (Backtracking Required)

// Input

// [[0,1,10],[0,2,5],[1,2,5]]


// Net balances

// 0: -15
// 1: +5
// 2: +10


// Optimal Settlement

// 0 → 1 (5)
// 0 → 2 (10)


// Output

// 2

// Test Case 10: Hard Case (LeetCode Favorite)

// Input

// [[0,1,10],[1,2,5],[2,0,5]]


// Net balances

// 0: -5
// 1: +5
// 2: 0


// Output

// 1

// Test Case 11: Larger Case (For DP / Bitmask)

// Input

// [[0,1,5],[0,2,5],[3,0,10],[2,3,5]]


// Net balances

// 0: 0
// 1: +5
// 2: 0
// 3: -5


// Output

// 1

// Test Case 12: Worst-Case (All Unique Balances)

// Input

// [[0,1,1],[2,3,2],[4,5,3],[6,7,4]]


// Net balances

// 0:-1, 1:+1
// 2:-2, 3:+2
// 4:-3, 5:+3
// 6:-4, 7:+4


// Output

// 4