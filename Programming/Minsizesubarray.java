/*Minimum Size Subarray Sum

Given an array of positive integers and target T,
 find the minimum length subarray whose sum is at least T.
 Example:

arr = [2,3,1,2,4,3]
target = 7
Output = 2 */
import java.util.*;
class Minsizesubarray
{
    static int minsum(int[] arr, int t)
    {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int left=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            while(sum>=t)
            {
              min=Math.min(min,i-left+1);
              sum-=arr[left];
              left++;
            }
        }
        return min;
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
        int t=sc.nextInt();
        int ans=minsum(arr,t);
        System.out.println(ans);
    }
}