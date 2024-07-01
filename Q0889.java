// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909

// '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 
// 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

// 성공

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        for(int c = 0; c < s.length(); c++) {
            if(stack.isEmpty() && s.charAt(c) == ')') {
                answer = false;
                break;
            } else if(s.charAt(c) == '(') {
                stack.push('(');
            } else {
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) {
           answer = false; 
        }
        return answer;
    }
}