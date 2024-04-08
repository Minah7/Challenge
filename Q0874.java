// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12899

// 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

// 124 나라에는 자연수만 존재합니다.
// 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.

// 성공

class Solution {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0) {
            int remainder = n % 3;
            n /= 3;
            
            if(remainder == 0) {
                n--;
            }
            
            answer = num[remainder] + answer;
        }
        return answer;
    }
}