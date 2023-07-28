// 문자열 my_string이 매개변수로 주어집니다. 
// my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i = myString.length()-1; i >= 0; i--) {
            answer += myString.charAt(i);
        }
        return answer;
    }
}