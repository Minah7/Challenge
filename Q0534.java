다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
image.png
지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.

성공

class Solution {
    public int solution(int[][] board) {
        //방향 설정 : Current, N, NE, E, SE, S, SW, W, NW
        int[][] dir = {{0,0},{-1, 0},{-1, 1},{0, 1},{1, 1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int b = board.length;
        int answer = 0;
        int[][] dangerArea = new int[b][b];
        //위험지역 파악
        for(int row = 0; row < b; row++) {
            for(int col = 0; col < b; col++) {
                if(board[row][col] == 1) {
                    for(int d= 0; d < dir.length; d++) {
                        if(0 <= row+dir[d][0] && row+dir[d][0] < b && 0 <= col+dir[d][1] && col+dir[d][1] < b) {
                            dangerArea[row+dir[d][0]][col+dir[d][1]]++;
                        }
                    }
                }
            }
        }
        //안전한 지역 수 파악
        for(int row = 0; row < b; row++) {
            for(int col = 0; col < b; col++) {
                if(dangerArea[row][col] == 0) answer++;
            }
        }
        return answer;
    }
}