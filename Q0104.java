// 문자열 binomial이 매개변수로 주어집니다. 
// binomial은 "a op b" 형태의 이항식이고 a와 b는 음이 아닌 정수, op는 '+', '-', '*' 중 하나입니다. 
// 주어진 식을 계산한 정수를 return 하는 solution 함수를 작성해 주세요.

class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] s = binomial.split(" ");
        int a = Integer.parseInt(s[0]);
        String op = s[1];
        int b = Integer.parseInt(s[2]);
        
        if (op.equals("+")) {
            answer = a + b;
        } else if (op.equals("-")) {
            answer = a - b;
        } else if (op.equals("*")) {
            answer = a*b;
        }
        return answer;
    }
}

// 성공