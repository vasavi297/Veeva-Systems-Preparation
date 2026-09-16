/*Max Consecutive Ones III
Problem: You are given a binary array nums containing only 0 and 1.You are also given an integer k.
You can flip at most k zeros into ones.
Your task is to find the maximum number of consecutive 1s that can be obtained after flipping at most k zeros.
Example 1
Input:
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
Output: 6 */
import java.util.*;
class MaxConsecutiveones
{
    static int consecutive(int[] nums,int k)
    {
        int n=nums.length;
        int left=0;
        int zerocount=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                zerocount++;
            }
            while(zerocount>k)
            {
                int rem=nums[left];
                if(rem==0)
                {
                    zerocount--;
                }
                left++;
            }
            max=Math.max(max,i-left+1);
        }
        return max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int ans=consecutive(nums,k);
        System.out.println(ans);
    }
}