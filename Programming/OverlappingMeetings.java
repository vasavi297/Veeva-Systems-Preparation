/*Given meeting intervals, find the maximum number of meetings happening at the same time.
Input:

n = 4
[1, 2]
[3, 4]
[5, 6]
[7, 8]

Output:

1 */
import java.util.*;

class Solution {
    public static int maxMeetings(int[][] meetings) {
        int n = meetings.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0;
        int current = 0;
        int max = 0;

        while (i < n) {
            if (start[i] < end[j]) {
                current++;
                max = Math.max(max, current);
                i++;
            } else {
                current--;
                j++;
            }
        }

        return max;
    }
}