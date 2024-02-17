// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/154538

// 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
// x에 n을 더합니다
// x에 2를 곱합니다.
// x에 3을 곱합니다.
// 자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.

// 성공

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y + 1];
        for(int i = 0; i < y + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[x] = 0;
        
        for(int i = x; i < y + 1; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            if(i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if(i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if(i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            } 
        }
        
        if(dp[y] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return dp[y];
    }
}