// my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 
// 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(String myString) {
        int answer = 0;
        String[] myS = myString.split(" ");
        
        answer += Integer.valueOf(myS[0]);
        for(int i = 1; i < myS.length; i++) {
            if(myS[i].equals("+")) {
                answer += Integer.valueOf(myS[i+1]);
            } else if(myS[i].equals("-")) {
                answer -= Integer.valueOf(myS[i+1]);
            }
        }
        return answer;
    }
}