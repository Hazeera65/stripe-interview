
import java.util.*;
public class penaltytime {
    public static List<Integer> penalty(String a) {
        List<Integer> k = new ArrayList<>();
        if (a.length() == 0) {
            return k;
        }
        String token[] = a.split(" ");
        Stack<Integer> q = new Stack<>();
        for (int i = 0; i < token.length; i++) {
            if (token[i].equals("BEGIN")) {
                q.push(i);
            } else if (token[i].equals("END")) {
                int u = q.pop();
               
                StringBuilder sb = new StringBuilder();
                for (int j = u + 1; j < i; j++) {
                    sb.append(token[j]);
                }
                int z = penaltytime(sb.toString());
                k.add(z);
            }
        }
       
        if (k.isEmpty() && a.matches("[YN]+")) {
            k.add(penaltytime(a));
        }
        return k;
    }
    public static int penaltytime(String a) {
        if (a.length() == 0) {
            return 0;
        }
        int open = 0;
        int ans = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'Y') {
                open++;
            }
        }
        int min = open;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'Y') {
                open--;
            } else {
                open++;
            }
            if (open < min) {
                min = open;
                ans = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String h = sc.nextLine();
        List<Integer> a = penalty(h);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}

// Test Case 4:
// Input:

// Expected Output:

// Test Case 5:
// Input:

// Expected Output:

// BEGIN BEGIN BEGIN YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY END END END
// 100
// 105
// 110
// BEGIN BEGIN BEGIN Y Y N Y END Y Y N N END Y N Y N EiiND
// 2
// 0
//  BEGIN BEGIN BEGIN YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY END END END