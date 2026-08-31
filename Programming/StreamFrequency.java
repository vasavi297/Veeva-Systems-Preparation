import java.util.*;
class StreamFrequency
{
    static LinkedHashMap<String,Integer> stream(String s)
    {
        LinkedHashMap<String,Integer>hm=new LinkedHashMap<>();
        String[] words=s.split("\\s+");
        for(String str:words)
        {
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> entry:hm.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return hm;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        stream(s);
    }
}