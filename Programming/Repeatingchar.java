/*Longest Repeating Character Replacement

Example:

s = "AABABBA"
k = 1
Output = 4 */
import java.util.*;
class Repeatingchar
{
    static int maxchar(String s,int k)
    {
        int n=s.length();
        int left=0;
        int max=Integer.MIN_VALUE;
        int freq=0;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            freq=Math.max(freq,hm.get(ch));
            while(((i-left+1)-freq)>k)
            {
                char rem=s.charAt(left);
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
        String s=sc.next();
        int k=sc.nextInt();
        int ans=maxchar(s,k);
        System.out.println(ans);
    }
}