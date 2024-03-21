// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/250125

// 보드의 각 칸에 칠해진 색깔 이름이 담긴 이차원 문자열 리스트 board와 
// 고른 칸의 위치를 나타내는 두 정수 h, w가 주어질 때 
// board[h][w]와 이웃한 칸들 중 같은 색으로 칠해져 있는 칸의 개수를 return 하도록 solution 함수를 완성해 주세요.

// 성공

class Solution {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            int dh = h + dir[i][0];
            int dw = w + dir[i][1];
            if(0 <= dh && dh < board.length && 0 <= dw && dw < board[0].length && board[h][w].equals(board[dh][dw])) {
                answer++;
            }
        }
        return answer;
    }
}