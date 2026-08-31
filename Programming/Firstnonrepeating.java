import java.util.*;
class Firstnonrepeating
{
    static char first(String str)
    {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(hm.get(ch)==1)
            {
                return ch;
            }
        }
        return '\0';
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char res=first(str);
        if(res!='\0')
        {
            System.out.println("The First Non Repeating Character is: "+res);
        }
        else
        {
            System.out.println("No Non Repeating Character Found");
        }
    }
}