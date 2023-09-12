// 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
// n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

// 실패. 에러  error: integer number too large double maxCheckNum = Math.sqrt(50000000000000);

class Solution {
    public long solution(long n) {
        long answer = 0;
        //n의 제곱근 범위 찾기
        double maxCheckNum = Math.sqrt(50000000000000);
        for(int i = 1; i < (int)maxCheckNum; i++) {
            if(Math.pow(i,2) == n) {
                return (i+1)*(i+1);
            } else if (Math.pow(i,2) > n) {
                break;
            }
        }
        return -1;
    }
}