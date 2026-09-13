/*Check if two strings are anagrams of each other
Input String 1 (s1)
Input String 2 (s2)
Expected Output
"listen"
"silent"
True
"anagram" 
"nagaram"
True
"a"
"a"
True
"geeksforgeeks"
"forgeeksgeeks"
True*/
import java.util.*;
class Anagram
{
    static boolean isAnagram(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        boolean ans=isAnagram(s1,s2);
        System.out.println(ans);
    }
}