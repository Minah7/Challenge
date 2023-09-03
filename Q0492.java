// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

// 제한 사항
// n은 0 이상 3000이하인 정수입니다.

// 성공

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int divisor = 1; divisor <= n; divisor++) {
            if(n%divisor == 0) answer += divisor;
        } 
        return answer;
    }
}