// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/169199

// 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 
// 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다. 
// "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, 
// "G"는 목표지점을 나타냅니다. 
// 게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 
// 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요. 
// 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.

// 성공

import java.util.*;

class Point{
    int x;
    int y;
    Point(int a, int b) {
        x = a;
        y = b;
    }
}
class Solution {
    int n, m;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        int[][] visit = new int[n][m];
        Queue<Point> que = new ArrayDeque();
        
        for(int row = 0; row < n; row++) {
            String s = board[row];
            for(int col = 0; col < m; col++) {
                if(s.charAt(col) == 'R') {
                    que.add(new Point(row, col));
                    visit[row][col] = 1;
                    break;
                }
            }
        }
        
        int answer = -1;
        while(!que.isEmpty()) {
            Point current = que.poll();
            if(board[current.x].charAt(current.y) == 'G') {
                answer = visit[current.x][current.y] - 1;
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                int dx = current.x + dir[d][0];
                int dy = current.y + dir[d][1];
                while(true) {
                    if(isInRange(dx, dy) && board[dx].charAt(dy) != 'D') {
                        dx += dir[d][0];
                        dy += dir[d][1];
                    } else {
                        dx -= dir[d][0];
                        dy -= dir[d][1];
                        break;
                    }
                }
                
                if(visit[dx][dy] == 0) {
                    que.add(new Point(dx, dy));
                    visit[dx][dy] = visit[current.x][current.y] + 1;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isInRange(int x, int y) {
        if(0 <= x && x < n && 0 <= y && y < m) {
            return true;
        }
        return false;
    }
}