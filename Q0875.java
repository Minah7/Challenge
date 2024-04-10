// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42898

// 격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 
// 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 
// 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.

// 성공

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];
        for(int i = 0; i < puddles.length; i++) {
            arr[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        
        arr[0][0] = 1;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(arr[r][c] == -1) {
                    arr[r][c] = 0;
                    continue;
                }
                if(r != 0) {
                    arr[r][c] += arr[r-1][c] % 1000000007;
                }
                if(c != 0) {
                    arr[r][c] += arr[r][c-1] % 1000000007;
                }
            }
        }
        return arr[n - 1][m - 1] % 1000000007;
    }
}