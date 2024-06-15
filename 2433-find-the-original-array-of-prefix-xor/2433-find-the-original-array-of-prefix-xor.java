/*
[problem]
- return array arr of size n -> pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]
    - ^ means the bitwize-xor operation (same -> 0(거짓), differ -> 1(참))
    - arr is unique
- given array pref of size n
*/

import java.util.*;

class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = pref.length - 1; i > 0; i--) {
            arr[i] = pref[i-1] ^ pref[i];
        }
        return arr;
    }
}