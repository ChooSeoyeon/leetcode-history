/*
[problem]
- given a string s, which contains stars *
- return the string after all stars have been removed
    - in one operation, you can
        - choose a star in s
        - remove the closest non-star character to its left, as well as remove the star itself
[solve]
- 스택
    - 주어진 문자열의 앞에서부터 확인했을 때
        - non-star면 스택에 넣음
        - star면 스택의 맨 위에 거 없앰
    - 문자열 전부다 확인했을 때 스택의 값이 정답
*/

import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }
}