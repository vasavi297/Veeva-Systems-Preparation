/*3. To find the first non-repeating character in a string, 
Test cases
Input
leetcode
Output
l or 0

Input
loveleetcode
Output
v or 2*/
import java.util.*;
class string
{
    public static char nonrepeating(String s)
    {

        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
            for(int i=0;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if(hm.get(ch)==1)
                {
                    return ch;
                }
            }
          return '0';
        }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char ans=nonrepeating(s);
        System.out.println("First Non Repeating char is:"+ans);
    }
}

 