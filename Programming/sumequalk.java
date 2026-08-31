import java.util.*;
public class sumequalk
{
    static int sum(int[] a,int k)
    {
        int n=a.length;
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int prefixsum=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            prefixsum+=a[i];
            if(hm.containsKey(prefixsum-k))
            {
                count+=hm.get(prefixsum-k);
            }
            hm.put(prefixsum,hm.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int res=sum(a,k);
        System.out.println(res);
    }
}
