import java.util.*;

class Cars
{
    static HashMap<String, Integer> cars(int n, String[] name, int[] price)
    {
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            if(!hm.containsKey(name[i]) || price[i] > hm.get(name[i]))
            {
                hm.put(name[i], price[i]);
            }
        }

        int max = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> e : hm.entrySet())
        {
            if(e.getValue() > max)
            {
                max = e.getValue();
            }
        }

        int count = 0;

        for(Map.Entry<String, Integer> e : hm.entrySet())
        {
            if(e.getValue() == max)
            {
                System.out.println(e.getKey() + " : " + e.getValue());
                count++;
            }
        }

        System.out.println("Number of cars = " + count);

        return hm;
    }

    public static void main(String args[])
{
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    String name[] = new String[n];
    int price[] = new int[n];

    // Read all names
    for(int i = 0; i < n; i++)
    {
        name[i] = sc.next();
    }

    // Read all prices
    for(int i = 0; i < n; i++)
    {
        price[i] = sc.nextInt();
    }

    HashMap<String, Integer> hm = cars(n, name, price);
}
}