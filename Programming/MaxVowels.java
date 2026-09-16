/*Maximum Number of Vowels in a Substring of Size K

Example:
s = "abciiidef", k = 3
Output: 3 */
import java.util.*;
class MaxVowels
{
    static int maxvowels(String s, int k)
    {
        int n=s.length();
        int left=0;
        int count=0;
        int maxcount=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            {
              count++;
            }
            if(i-left+1==k)
            {
                maxcount=Math.max(maxcount,count);
                char rem=s.charAt(left);
                if(rem=='a'||rem=='e'||rem=='i'||rem=='o'||rem=='u')
                {
                    count--;
                }
                left++;
            }
        }
        return maxcount;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        int ans=maxvowels(s, k);
        System.out.println(ans);
    }
}