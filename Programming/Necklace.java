/*Necklace — Problem Explanation
You are given a necklace containing n pearls. Each pearl has an integer written on it.
You need to move the first k pearls to the end of the necklace while keeping their order unchanged.
Example
Original necklace:
1 5 3 4 2
Here:
n = 5
k = 2
The first 2 pearls are:
1 5
Move them to the end:
3 4 2 1 5
So the answer is:
3 4 2 1 5*/
import java.util.*;

public class Necklace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] pearls = new int[n];

            for (int i = 0; i < n; i++) {
                pearls[i] = sc.nextInt();
            }

            k = k % n;

          
            for (int i = k; i < n; i++) {
                System.out.print(pearls[i] + " ");
            }

            for (int i = 0; i < k; i++) {
                System.out.print(pearls[i] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}