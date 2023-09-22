// 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
// 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
// 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        //상, 상우, ...
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1, 0};
        int[][] danger = new int[board.length][board.length];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                if(board[row][col] == 1) {
                    for(int i = 0; i < dr.length; i++) {
                        if(0 <= row+dr[i] && row+dr[i] < board.length && 0 <= col+dc[i] && col+dc[i] < board.length) {
                            danger[row+dr[i]][col+dc[i]] = 1;
                        }
                    }
                }
            }
        }
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                if(danger[row][col] == 0) answer++;
            }
        }
        return answer;
    }
}