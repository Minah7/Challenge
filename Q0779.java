// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/155652

// 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
// index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
// skip에 있는 알파벳은 제외하고 건너뜁니다.

//성공.

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            for(int idx = 0; idx < index; idx++) {
                letter++;
                if(letter > 'z') {
                    letter -= 26;
                }
                if(skip.contains(String.valueOf(letter))) {
                    idx--;
                    continue;
                }
            }
            answer += letter;
        }
        return answer;
    }
}