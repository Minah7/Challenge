// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502

// 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
// 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 
// s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return

//성공.

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLen = s.length();
        for(int rotate = 0; rotate < sLen; rotate++){
            Stack<Character> stack = new Stack<>();
            int idx = rotate;
            int cnt = 0;
            for(int i = 0; i < sLen; i++){
                if(idx == sLen){
                    idx = 0;
                }
                if(s.charAt(idx) == '(' || s.charAt(idx) == '[' || s.charAt(idx) == '{') {
                    stack.push(s.charAt(idx));
                } else if(!stack.isEmpty()) {
                    if(s.charAt(idx) == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if(s.charAt(idx) == '}' && stack.peek() == '{') {
                     stack.pop();
                    } else if(s.charAt(idx) == ']' && stack.peek() == '[') {
                     stack.pop();
                    }
                } else {
                    break;
                }
                idx++;
                cnt++;
            }
            if(stack.isEmpty() && cnt == sLen) {
                answer++;
            }
        }
        return answer;
    }
}