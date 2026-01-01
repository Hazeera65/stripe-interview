import java.util.*;
import java.io.*;
class Penaltytime {
 public static int  penalty(String a){
if(a.length()==0){
    return 0;
}
int open=0;

int ans =0;
for(int i=0;i<a.length();i++){
    if(a.charAt(i)=='Y'){
        open++;
    }
}
int min=open;
for(int i=0;i<a.length();i++){
    if(a.charAt(i)=='Y'){
        open--;
    }
    else{
        open++;
    }
    if(open<min){
        min=open;
        ans =i+1;
    }
}
return ans;
    }
    public static void main(String[] args){
           Scanner sc =new Scanner(System.in);
           String a=sc.next();
        
           System.out.print(penalty(a));
    }
}


// All customers arrive:
// Input: YYYY
// Expected Output: 4

// No customers arrive:
// Input: NNNN
// Expected Output: 0

// Alternating arrivals:
// Input: YNYN
// Expected Output: 1

// Random pattern:
// Input: NYNY
// Expected Output: 2