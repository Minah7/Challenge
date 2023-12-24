// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909
// '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 
// 문자열 s가 올바른 괄호이면 true를, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
// 성공

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int idx = -1; // '('의 개수를 알기 위한 변수
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                idx++;
            } else {
                //만일 '('이 없는 상태에서 ')'를 만나는 상황 처리
                if(idx == -1) {
                    answer = false;
                    break;
                // '('가 있는 상황
                } else {
                    idx--;
                }
            }
        }
        // 마지막에 '('가 남아있으면 false 처리
        if(idx != -1) answer = false;

        return answer;
    }
}