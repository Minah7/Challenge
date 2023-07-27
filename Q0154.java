// 문자열 my_string과 정수 n이 매개변수로 주어질 때, 
// my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.

// 성공

class Solution {
    public String solution(String myString, int n) {
        String answer = "";
        for(int i = 0; i < myString.length(); i++) {
            for(int j=1; j <= n; j++)
            answer += myString.charAt(i);
        }
        return answer;
    }
}