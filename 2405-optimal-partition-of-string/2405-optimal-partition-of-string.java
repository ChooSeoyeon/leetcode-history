/*
[problem]
- Given a string s
- Return the minimum number of substrings in such a partition
    - partition the string into one or more substrings such that the characters in each substring are unique
    - no letter appears in a single substring more than once
    - each character should belong to exactly one substring in a partition
[solve] greedy
- Starting from the beginning, create a substring that is as long as possible
*/
import java.util.*;

class Solution {
    public int partitionString(String s) {
        int count = 1;
        String substring = "";
        for (char c : s.toCharArray()) {
            if (substring.contains(String.valueOf(c))) {
                count++;
                substring = "";
            }
            substring += String.valueOf(c);
        }
        return count;
    }
}