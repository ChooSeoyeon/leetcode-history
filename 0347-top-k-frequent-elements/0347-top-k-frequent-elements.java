/*
[problem]
- given: an integer array nums and an integer k
- return: the k most frequent elements
    - return the answer in any order
*/
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(map.entrySet());
        
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.remove().getKey();
        }
        return answer;
    }
}