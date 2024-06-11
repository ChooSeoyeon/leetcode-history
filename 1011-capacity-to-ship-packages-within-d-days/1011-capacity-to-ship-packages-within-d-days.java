/*
[problem]
- return: the least weight capacity of the ship that can ship all the packages (on the conveyor belt) within n days
- given: packages weights, days
- condition: 
    - can't loat more weight than the maximum weitht capacity of the ship
    - package must be shipped in the order given
[solve] parametric search (...x,x,x,o,o,o...) -> (10,...12,13,14,15,16,17,...,55)
- input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
- answer: weitht capacity of the ship
- answer's range: 10(minimum of weights)..55(sum of weights)
- answer's verification: find last x (and then find first o by +1)
    - 32: 32-1-2-3-4-5-6-7 / 32-8-9-10 -> o(possible)
    - 20: 20-1-2-3-4-5 / 20-6-7 / 20-8-9 / 20-10 -> o(possible)
    - 15: 15-1-2-3-4-5 / 20-6-7 / 20-8-9 / 20-10 -> o(possible)
    - 12: 12-1-2-3-4 / 12-5-6 / 12-7 / 12-8 / 12-9 / 12-10 -> x(impossible)
    - 13: 13-1-2-3-4 / 13-5-6 / 13-7 / 13-8 / 13-9 / 13-10 -> x(impossible)
    - 14: 14-1-2-3-4 / 14-5-6 / 14-7 / 14-8 / 14-9 / 14-10 -> x(impossible)
    -> we found that 14 is last x and 15 is first o, so answer is 15
*/
import java.util.*;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int result = 0;
        int left = 0;
        int right = 500 * 50000;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isImpossibleWeight(mid, weights, days)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    private boolean isImpossibleWeight(int mid, int[] weights, int days) {
        int j = 0;
        for (int i = 0; i < days; i++) {
            int capacity = mid;
            while (capacity - weights[j] > 0) {
                if (j == weights.length - 1) {
                    return false;
                }
                capacity -= weights[j];
                j++;
            }
        }
        return true;
    }
}