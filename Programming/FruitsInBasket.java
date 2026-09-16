/*Fruit Into Baskets

Find the longest contiguous subarray containing at most 2 distinct values. */
import java.util.*;
class FruitsInBasket
{
    static int fruit(int[] arr)
    {
        int n=arr.length;
        int left=0;
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            while(hm.size()>2)
            {
              int rem=arr[left];
              hm.put(rem,hm.get(rem)-1);
              if(hm.get(rem)==0)
              {
                hm.remove(rem);
              }
              left++;
            }
            max=Math.max(max,i-left+1);
        }
        return max==Integer.MIN_VALUE?0:max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans=fruit(arr);
        System.out.println(ans);
    }
}