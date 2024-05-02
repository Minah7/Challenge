// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12900?language=java

// 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 
// 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다.

// 직사각형의 가로의 길이 n이 매개변수로 주어질 때, 
// 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.

// 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.

// 성공

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return dp[n];
    }
}