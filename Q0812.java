// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/49994

// 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
// U: 위쪽으로 한 칸 가기
// D: 아래쪽으로 한 칸 가기
// R: 오른쪽으로 한 칸 가기
// L: 왼쪽으로 한 칸 가기

// 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 
// 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.

// 명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return

// 성공

class Solution {
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] visited = new boolean[4][11][11];
        int[] start = {5, 5};
        
        for(int i = 0; i < dirs.length(); i++) {
            int row = start[0];
            int col = start[1];
            int d = 0;
            if(dirs.charAt(i) == 'U') {
                d = 0;
            } else if(dirs.charAt(i) == 'D') {
                d = 1;
            } else if(dirs.charAt(i) == 'R') {
                d = 2;
            } else if(dirs.charAt(i) == 'L') {
                d = 3;
            } 
            row += direction[d][0];
            col += direction[d][1];
            if(0 <= row && row < 11 && 0 <= col && col < 11) {
                int oppositeD = (d%2 == 1)? d-1: d+1; // 왕복 처리
                
                if(!visited[d][row][col]) {
                    visited[d][row][col] = true;
                    answer++;
                    visited[oppositeD][start[0]][start[1]] = true;
                }
                start[0] = row;
                start[1] = col;
            }
        }
        return answer;
    }
}