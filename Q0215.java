// my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 
// 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.

// 테스트 실패.. (10개 중 8개 실패)

class Solution {
    public int solution(String myString) {
        int answer = 0;
        String[] myS = myString.split(" ");
        
        if(myS[1].equals("+")) {
            answer = Integer.parseInt(myS[0]) + Integer.parseInt(myS[2]);
        } else if(myS[1].equals("-")) {
            answer = Integer.parseInt(myS[0]) - Integer.parseInt(myS[2]);
        }
        return answer;
    }
}