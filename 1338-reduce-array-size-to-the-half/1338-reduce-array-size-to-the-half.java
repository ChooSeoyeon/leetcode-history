/*
[problem]
- given an integer array arr
    - choose a set of integers and remove all the occurrences of these integers in the array
- return the minimum size of the set so that at least half of the integers of the array are removed
[solve]
- 각 숫자의 개수들 집계하기 -> 개수: 1,2,3,4 / 총 개수: 10
- 개수들 중 큰 수부터 뽑아서 총 개수에서 빼보기
- 뺀 값이 원래 총 개수의 절반 이하가 된 시점이 정답.
*/
import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int value : map.values()) {
            pq.add(value);
        }
        
        int total = arr.length;
        int half = total / 2;
        int count = 0;
        while (total > half) {
            total -= pq.remove();
            count++;
        }
        
        return count;
    }
}