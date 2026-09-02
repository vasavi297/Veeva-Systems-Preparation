import java.util.*;
class FirstRepeating
{
    static int firstindex(String s)
    {
        int n=s.length();
        int minindex=Integer.MAX_VALUE;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(hm.get(ch)>1)
            {
                minindex=Math.min(minindex,s.indexOf(ch));
            }
        }
        if(minindex==Integer.MAX_VALUE)
        {
            minindex=-1;
        }
        return minindex;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int ans=firstindex(s);
        System.out.println(ans);
    }
}
