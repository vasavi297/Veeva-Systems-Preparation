//Given a fibnocci number find its next and prev fibnocci numbers
//8                21
//o/p:5 13      o/p:13 34
import java.util.*;
class fibnocci
{
    static int[] fib(int n)
    {
        int prev=0;
        int curr=1;
        while(curr<n)
        {
            int next=prev+curr;
            prev=curr;
            curr=next;
        }
       int finalnext=prev+curr;
       return new int[]{prev,finalnext};
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ans=fib(n);
        System.out.println(ans[0]+" "+ans[1]);
    }
}