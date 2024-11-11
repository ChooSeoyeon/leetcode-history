/*
[problem]
- given: string s [0..5*10^4]
    - s consists of English letters, digits, symbols and spaces
- return: find the length of the longest substring without repeating characters
    - substring: contiguous non-empty sequence of characters within a string
[solve] slidingWindow
- solve_1: slidingWindow + hashSet (remember exist) -> T: O(N), S: O(1)
    - make first slice
        - add char to hashSet
        - set left = 0, right = 0
    - repeat: move left and check slice
        - if same things already exists in set -> move left while same things doesnt exist in set
            - dvdf
                3) dvd -> vd (remove char from the front while duplicated char is removed)
        - if same things doesnt exist in set -> add char to set & renew max slice size 
            - dvdf
                1) d
                2) dv
                4) vdf
- solve_2: slidingWindow + hashMap (remeber last seen)
    - make first slice
        - add (char,index) to map (index will be represented last seen location)
        - set left = 0, right = 0
    - repeat: move left and check slice
        - if same things already exists in map && same things last seen index is in the slice(last seen index >= left) -> move left to last seen index + 1
        - if same things doesn't exist in map -> add char to map & renew max slice size
*/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}