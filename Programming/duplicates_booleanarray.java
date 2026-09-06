import java.util.*;
class duplicates_booleanarray
{
    static int[] unique(int a[])
    {
        if(a.length==0)
            return new int[0];
        int max=a[0];
        for(int i=1;i<a.length;i++)
        {
           if(a[i]>max)
           {
            max=a[i];
           }
        }
        boolean[] visited=new boolean[max+1];
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(!visited[a[i]])
            {
              visited[a[i]]=true;
              count++;
            }
        }
        int[] ans=new int[count];
        int j=0;
        for(int i=0;i<a.length;i++)
        {
            if(visited[a[i]])
            {
                ans[j++]=a[i];
                visited[a[i]]=false;
            }
        }
    return ans;
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
        int[] res=unique(a);
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
    }
}