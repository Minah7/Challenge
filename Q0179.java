// 문자열 my_string이 매개변수로 주어집니다. 
// my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

// 실패

class Solution {
    public int solution(String myString) {
        int answer = 0;
        for(int i = 0; i < myString.length(); i++) {
            Boolean digit = Character.isDigit(myString.charAt(i));
            if(digit) {
                answer += Integer.valueOf(myString.charAt(i));
            }
        }
        return answer;
    }
}