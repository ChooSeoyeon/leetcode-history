import java.util.*;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] DP = new int[arr.length + 1];
        DP[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            int max = 0;
            for (int j = 1; j <= k; j++) {
                if (i < j) {
                    continue;
                }
                int compare = DP[i - j] + findMax(arr, i - j + 1, i) * j;
                if (max < compare) {
                    max = compare;
                }
            }
            DP[i] = max;
        }
        return DP[arr.length];
    }

    public int findMax(int[] arr, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (max < arr[i - 1]) {
                max = arr[i - 1];
            }
        }
        return max;
    }
}
/*
[1,15,7,9,2,5,10], k = 3
DP[0] = 0
DP[1] = max (                0+1*1) = 1
DP[2] = max (        0+15*2, 1+15*1) = 30
DP[3] = max (0+15*3, 1+15*2, 30+7*1) = 45
DP[4] = max (1+15*3, 30+9*2, 45+9*1) = 57
DP[5] = max (30+9*3, 45+9*2, 57+2*1) = 63
DP[6] = max (45+9*3, 57+5*2, 63+5*1) = 72
DP[7] = max (57+10*3, 63+10*2, 72+10*1) = 87
*/