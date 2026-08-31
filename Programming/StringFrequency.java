import java.util.*;
class StringFrequency
{
    static Map<String,Integer> findfreq(String arr[])
    {
        int n=arr.length;
        HashMap<String,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);   
        }
        for(Map.Entry<String,Integer>e:hm.entrySet())
        {
            System.out.println(e.getKey()+" : "+e.getValue());
        }
        return hm;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.next();
        }
        Map<String,Integer>res=findfreq(arr);
    }
}