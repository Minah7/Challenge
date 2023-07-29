// 문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i = 0; i < myString.length(); i++) {
            char a = myString.charAt(i);
            if(Character.isLowerCase(a)) {
                answer += Character.toUpperCase(a);
            } else {
                answer += Character.toLowerCase(a);
            }
        }
        return answer;
    }
}