// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844

// 게임 맵의 상태 maps가 매개변수로 주어질 때, 
// 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 
// 최솟값을 return 하도록 solution 함수를 완성해주세요. 
// 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

// 성공

import java.util.*;

class Solution {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int solution(int[][] maps) {        
        int n = maps.length;
        int m = maps[0].length;
        int[][] cnt = new int[n][m];
        
        bfs(maps, cnt, n, m);
        
        if(cnt[n - 1][m - 1] == 0) {
            return -1;
        }
        return cnt[n - 1][m - 1];
    }
    static void bfs(int[][] maps, int[][] cnt, int n, int m) {
        cnt[0][0] = 1;
        
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[] {0, 0});
        
        while(!que.isEmpty()) {
            Integer[] get = que.poll();
            int r = get[0];
            int c = get[1];
            for(int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(0 <= nr && nr < n && 0 <= nc && nc < m && maps[nr][nc] == 1 && cnt[nr][nc] == 0) {
                    cnt[nr][nc] = cnt[r][c] + 1;
                    que.add(new Integer[] {nr, nc});
                }
            }
        }
    }
}