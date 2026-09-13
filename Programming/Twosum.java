/*Find two numbers in an array that add up to a specific target value.

Input: 
nums = [2, 7, 11, 15], target = 9
Output: [0, 1] 
(since 2 + 7 = 9) 

 Input: nums = [3, 2, 4], target = 6

Expected Output: [1, 2] (since 2 + 4 = 6)

 Input: nums = [3, 3], target = 6
Output: [0, 1]

Input: 
nums = [5, 10], target = 15
Output: [0, 1] 
Input: nums = [-3, 4, 3, 90], target = 0

Output: [0, 2]


Input: nums = [-1, -2, -3, -4, -5], target = -8
Output: [2, 4] (since -3 + -5 = -8)

Input: nums = [0, 4, 3, 0], target = 0
Output: [0, 3]*/
import java.util.*;
class Twosum
{
    public static int[] twosum(int[] nums,int target)
    {
        int n=nums.length;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
          int num=nums[i];
          if(hm.containsKey(target-num))
          {
            return new int[] {hm.get(target-num), i};
          }
          hm.put(num,i);
        }
        return new int[] {};
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        int[] ans=twosum(nums,target);
        System.out.print(Arrays.toString(ans));

    }
}