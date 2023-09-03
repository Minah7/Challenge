// 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
// n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

// 성공

class Solution {
    public long solution(long n) {
        long answer = 0;
        for(long x = 1; x < 7080000; x++) {
            if(x*x == n) {
                answer = (x+1)*(x+1);
                break;
            } else if(x*x > n) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}