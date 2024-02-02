// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946

// 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 
// 2차원 배열 dungeons 가 매개변수로 주어질 때, 유저가 탐험할수 있는 최대 던전 수를 return

// 성공

class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, k, 0);
        return answer;
    }
    public void dfs(int[][] dungeons, boolean[] visited, int k, int rest, int depth) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && rest >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, visited, k, rest - dungeons[i][1], depth + 1);
                visited[i] = false;
            } else {
                if(depth > answer) {
                    answer = depth;
                }
            }
        }
    }
}