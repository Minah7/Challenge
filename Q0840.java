// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105

// 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 
// 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

// 성공

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for(int m = 1; m <= i; m++) {
                dp[i][m] = Math.max(dp[i - 1][m], dp[i - 1][m - 1]) + triangle[i][m];
            }
            
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        
        return answer;
    }
}