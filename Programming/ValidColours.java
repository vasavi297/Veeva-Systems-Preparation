import java.util.*;
class ValidColours
{
    public static HashMap<String,Integer> colors(String s)
    {
        String[] arr=s.split(",");
        HashMap<String,Integer>hm=new HashMap<>();
       
        for(String str:arr)
        {
            str=str.trim();
            str=str.replaceAll("[^a-zA-Z]","");
            str=str.toLowerCase();
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        return hm;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        HashMap<String,Integer>hm=colors(s);
        for(Map.Entry<String,Integer>e:hm.entrySet())
        {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
}