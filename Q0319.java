// 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.

// 성공

class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0) == '-') {
            s = s.replace("-","");
            answer = Integer.valueOf(s)*-1;
        } else if(s.charAt(0) == '+') {
            s = s.replace("+","");
            answer = Integer.valueOf(s);
        } else {
            answer = Integer.valueOf(s);
        }
        return answer;
    }
}