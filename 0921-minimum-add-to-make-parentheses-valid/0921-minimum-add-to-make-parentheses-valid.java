/*
[problem]
- given a parentheses string s
    - in one move, you can insert a parenthesis at any position of the string
- return the minimum number of moves required to make s valid
    - a parentheses string is valid if and only if:
        - It is the empty string
        - It can be written as AB (A concatenated with B), where A and B are valid strings
        - It can be written as (A), where A is a valid string
[solve]괄호 짝짓기
- 스택에 열린 괄호 넣다가 닫힌 괄호 나오면 스택의 맨 위의 열린 괄호 지우기
- 닫힌 괄호 나왔는데 스택이 비어있다면, 한 개 카운팅하기
- 문자열 전부 살폈는데 스택에 남아있는 열린괄호가 있다면 그 개수만큼 카운팅하기
*/
import java.util.*;

class Solution {
    public int minAddToMakeValid(String s) {
        int stack = 0;
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack++;
            } else {
                if (stack == 0) {
                    answer++;
                } else {
                    stack--;
                }
            }
        }
        return answer + stack;
    }
}