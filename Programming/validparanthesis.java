import java.util.*;
public class validparanthesis {
    static boolean isValid(String s)
    {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='[')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }
                char top=st.peek();
                if((ch==')'&&top=='(')||(ch=='}'&&top=='{')||(ch==']'&&top=='['))
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        boolean res=isValid(s);
        if(res)
        {
            System.out.println("The Paranthesis is Valid");
        }
        else
        {
            System.out.println("The Paranthesis is Invalid");
        }
    }
    
}
