import java.util.*;

class Solution {
    //동, 서, 남, 북 방향으로 이동
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(int[][] maps) {
        int answer = 0;
        // 경로 값 넣을 배열
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1; //시작하는 곳 경로 1로 만들어주기
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] {0, 0});
        while(!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int d = 0; d < 4; d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                if(0 <= nr && nr < maps.length && 0 <= nc && nc < maps[0].length && visited[nr][nc] == 0 && maps[nr][nc] == 1) {
                    visited[nr][nc] = visited[r][c]+1;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
    }
}