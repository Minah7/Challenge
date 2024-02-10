// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12914

// 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
// (1칸, 1칸, 1칸, 1칸)
// (1칸, 2칸, 1칸)
// (1칸, 1칸, 2칸)
// (2칸, 1칸, 1칸)
// (2칸, 2칸)
// 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 
// 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 
// 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.

// 두번째 시도 성공!

class Solution {
    public long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 2001; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}

// 첫번째 도전 실패. 37.5

class Solution {
    static long answer = 0;
    public long solution(int n) {
        dfs(n, 0);
        return answer % 1234567;
    }
    
    public void dfs(int n, int sum) {
        if(sum == n) {
            answer++;
        } else {
            if((sum + 2) <= n) {
                dfs(n, sum + 2);
            }
            dfs(n, sum + 1);
        }
    }
}