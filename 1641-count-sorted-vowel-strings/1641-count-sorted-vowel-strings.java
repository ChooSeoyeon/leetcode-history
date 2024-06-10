import java.util.*;

class Solution {
    public int countVowelStrings(int n) {
        int[][] s = new int[n][5];
        for (int i = 1; i < 5; i++) {
            s[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            s[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                s[i][j] = s[i-1][j] + s[i][j-1];
            }
        }
        
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += s[n-1][i] * (5 - i);
        }
        return result;
    }
}