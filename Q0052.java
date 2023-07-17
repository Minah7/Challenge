// 정수 배열 numLog가 주어집니다. 
// 처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 
// 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.

class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for (int i = 1; i <numLog.length; i++) {
            if((numLog[i] - numLog[i-1]) == 1) {
                answer += "w";
            } else if((numLog[i] - numLog[i-1]) == -1) {
                answer += "s";
            } else if((numLog[i] - numLog[i-1]) == 10) {
                answer += "d";
            } else if((numLog[i] - numLog[i-1]) == -10) {
                answer += "a";
            }
        }
    return answer;
    }
}

//성공