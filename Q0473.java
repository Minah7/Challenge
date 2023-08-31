// 양의 정수 n이 매개변수로 주어질 때, n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고 n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.

// 성공

class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n%2 == 0) {
            for(int i = 0; i <= n; i+=2) {
                answer += i*i;
            }
        } else {
            for(int i = 1; i <= n; i+=2) {
                answer += i;
            }
        }
        return answer;
    }
}