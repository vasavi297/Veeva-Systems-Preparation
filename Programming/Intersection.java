import java.util.*;
public class Intersection {
    static ArrayList<Integer> inter(int a[],int b[])
    {
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<b.length;j++)
            {
            if(a[i]==b[j])
            {
                hs.add(a[i]);
            }
        }
    }
    return new ArrayList<Integer>(hs);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int b[]=new int[m];
        for(int i=0;i<m;i++)
        {
            b[i]=sc.nextInt();
        }
        ArrayList<Integer>res=inter(a,b);
        System.out.println("The Intersection Elements are : "+res);
    }
}
