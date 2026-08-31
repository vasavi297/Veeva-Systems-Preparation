import java.util.*;
public class product {
    static ArrayList<Integer>prod(int a[])
    {
        ArrayList<Integer>al=new ArrayList<>();
        int n=a.length;
        int prevprod=1;
        for(int i=0;i<n;i++)
        {
            int rightprod=1;
            for(int j=i+1;j<n;j++)
            {
                rightprod=rightprod*a[j];
            }
            int res=prevprod*rightprod;
            al.add(res);
            prevprod=prevprod*a[i];
        }
        return al;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        ArrayList<Integer> ans=prod(a);
        System.out.println(ans);
    }

}
