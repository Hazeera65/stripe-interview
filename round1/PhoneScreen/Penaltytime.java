import java.util.*;
import java.io.*;
class Penaltytime {
    public static int  penalty(String a,int cost){
if(a.length()<cost || cost==-1){
return -1;
}
int no=0;
int yes =0;
for(int i=0;i<a.length();i++){
    if(cost>i){
    if(a.charAt(i)=='N'){
        no++;
    }
    
}
else{
    if(a.charAt(i)=='Y'){
        yes++;
    }
}
}
return no+yes;
    }
    public static void main(String[] args){
           Scanner sc =new Scanner(System.in);
           String a=sc.next();
        int cost =sc.nextInt();
           System.out.print(penalty(a,cost));
    }
}