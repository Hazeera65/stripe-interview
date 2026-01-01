
import java.util.*;
public class BracketExpantion {

public static List<String> check(String u){
ArrayList<String> y = new ArrayList<>();
if (u.length()<=0) {
    return y;
}
checking(u,y,0,new StringBuilder());
Collections.sort(y);
    return y;
}
public static void checking(String u, ArrayList<String> y, int index, StringBuilder current) {
    if (index >= u.length()) {
        y.add(current.toString());
        return;
    }
    if (u.charAt(index) == '{') {
        int j = index + 1;
        while (j < u.length() && u.charAt(j) != '}') {
            j++;
        }
        
        String[] h = u.substring(index + 1, j).split(",");
        for (String w : h) {
            
            current.append(w);
            checking(u, y, j + 1, current);
            current.setLength(current.length()-w.length());
        }
    } else {
        current.append(u.charAt(index));
        checking(u, y, index + 1, current);
        current.deleteCharAt(current.length() - 1);
    }
}


    public static void main(String[] args){
        Scanner o = new Scanner(System.in);
        String a=o.next();
        List<String> k =check(a);
        for(int i=0;i<k.size();i++){
            System.out.println(k.get(i));
        }
    }
}
// }
// Basic Single Expansion
// Input
// {u,v}w

// Output
// uw
// vw

// 2. No Comma Inside Braces (Your Current Case)
// Input
// {uv}w

// Output
// uvw


// ✔ Correct — only one option exists.

// 3. Multiple Characters per Option
// Input
// {ab,cd}e

// Output
// abe
// cde

// 4. Multiple Brace Groups
// Input
// {a,b}c{d,e}

// Output
// acd
// ace
// bcd
// bce

// 5. Braces at the End
// Input
// x{y,z}

// Output
// xy
// xz

// 6. No Braces (Plain String)
// Input
// abc

// Output
// abc
