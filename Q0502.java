// 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
// 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

// 제한 사항
// 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
// 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

// 성공

class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0; //짝수홀수를 셀 변수
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                cnt = 0;
                answer += " ";
            } else if(s.charAt(i) != ' ') {
                cnt++;
                if(cnt%2 == 1) {
                    answer += s.substring(i,i+1).toUpperCase();
                } else if(cnt%2 == 0) {
                    answer += s.substring(i,i+1).toLowerCase();
                }
            }
        }
        return answer;
    }
}