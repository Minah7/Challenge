// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12951

// 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

// 실패

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] words = s.split(" ");
        String answer = "";
        for(int i = 0; i < words.length; i++) {
            char start = words[i].charAt(0);
            int checkNum = start - 'a';
            if(0 <= checkNum && checkNum < 26) {
                answer += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            } else {
                answer += words[i];
            }
            if(i != words.length - 1) {
                answer += " ";
            }
        }
        return answer;
    }
}