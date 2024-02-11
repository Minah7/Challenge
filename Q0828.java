// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java

// 석유가 묻힌 땅과 석유 덩어리를 나타내는 2차원 정수 배열 land가 매개변수로 주어집니다. 
// 이때 시추관 하나를 설치해 뽑을 수 있는 가장 많은 석유량을 return 하도록 solution 함수를 완성해 주세요.

// 첫번째 시도 실패. 정확성 100%, 효율성 0%..ㅠㅠ

import java.util.*;

class Solution {
    static int answer = 0;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public int solution(int[][] land) {
        int row = land.length; 
        int col = land[0].length;
        
        for(int c = 0; c < col; c++) {
            boolean[][] visited = new boolean[row][col];
            bfs(land, visited, row, col, c, 0);
        }
        
        return answer;
    }
    public void bfs(int[][] land, boolean[][] visited, int row, int col, int c, int sum) {
        for(int r = 0; r < row; r++) {
            if(land[r][c] == 1 && visited[r][c] == false) {
                int nr = r;
                int nc = c;
                Queue<int[]> que = new LinkedList<>();
                que.add(new int[] {nr, nc});
                visited[nr][nc] = true;
                int cnt = 1;
                
                while(!que.isEmpty()) {
                    int[] cur = que.poll();
                    
                    for(int d = 0; d < 4; d++) {
                        int tmpR = cur[0] + dr[d];
                        int tmpC = cur[1] + dc[d];
                        if(tmpR < 0 || tmpR >= row || tmpC < 0 || tmpC >= col || land[tmpR][tmpC] == 0 || visited[tmpR][tmpC]) {
                            continue;
                        }
                        que.add(new int[] {tmpR, tmpC});
                        visited[tmpR][tmpC] = true;
                        cnt++;
                    }
                }
                sum += cnt;
            }
        }
        answer = Math.max(answer, sum);
    }
}