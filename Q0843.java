// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946

// 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 
// 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 
// 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        dfs(dungeons, visited, k, k, 0);
        return answer;
    }
    static void dfs(int[][] dungeons, boolean[] visited, int k, int rest, int complete) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && rest >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, visited, k, rest - dungeons[i][1], complete + 1);
                visited[i] = false;
            } else {
                answer = Math.max(answer, complete);
            }
        }
    }
}