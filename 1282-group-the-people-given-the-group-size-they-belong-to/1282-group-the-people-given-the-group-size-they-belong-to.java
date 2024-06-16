/*
[provlem]
return: a list of groups such that each person i is in a group of size groupSizes[i]
given: groupSizes
    - groupSizes[i] is the size of the group that person i is in 
        (ex. groupSize[1]=3 -> person 1 must be in a group of size 3)
    - Each person is labeled with a unique ID from 0 to n - 1
[solution]
- groupSizes = [3,3,3,3,3,1,3]
    - people 0,1,2,3,4,6 is in a group of size 3 -> [0,1,2], [3,4,6]
    - people 5 is in a group of size 1 -> [5]
*/

import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getKey();
            List<Integer> people = entry.getValue();
            List<Integer> subGroup = new ArrayList<>();
            for (int person : people) {
                if (subGroup.size() == size) {
                    answer.add(subGroup);
                    subGroup = new ArrayList<>();
                } 
                subGroup.add(person);
            }
            if (subGroup.size() == size) {
                answer.add(subGroup);
            }
        }
        return answer;
    }
}