// rows x columns 크기인 행렬이 있습니다. 
// 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다. 
// 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다. 
// 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.

// x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
// 다음은 6 x 6 크기 행렬의 예시입니다.

// 이 행렬에 (2, 2, 5, 4) 회전을 적용하면, 아래 그림과 같이 2행 2열부터 5행 4열까지 영역의 테두리가 시계방향으로 회전합니다. 
// 이때, 중앙의 15와 21이 있는 영역은 회전하지 않는 것을 주의하세요.

// 행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때, 
// 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // 보드 생성 + 값 넣기
        int[][] board = new int[rows+1][columns+1];
        int num = 1;
        for(int r = 1; r <= rows; r++) {
            for(int c = 1; c <= columns; c++) {
                board[r][c] = num++;
            }
        }
        // queries 개수만큼 회전 실행
        for(int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0];
            int y1 = queries[q][1];
            int x2 = queries[q][2];
            int y2 = queries[q][3];
            List<Integer> arrNum = new ArrayList<>();
            for(int n = y1; n <= y2; n++) {
                arrNum.add(board[x1][n]);
            } // 위
            for(int e = x1+1; e < x2; e++) {
                arrNum.add(board[e][y2]);
            } // 오른쪽
            for(int s = y2; s >= y1; s--) {
                arrNum.add(board[x2][s]);
            } // 아래
            for(int w = x2-1; w > x1; w--) {
                arrNum.add(board[w][y1]);
            } // 왼쪽
            
            //가장 작은 수 구해서 answer array에 담아주기.
            answer[q] = Collections.min(arrNum);
            
            // 지금부터 회전된 값 넣어주기
            int idx = 0;
            for(int n = y1+1; n <= y2; n++) {
                board[x1][n] = arrNum.get(idx++);
            } // 위
            for(int e = x1+1; e < x2; e++) {
                board[e][y2] = arrNum.get(idx++);
            } // 오른쪽
            for(int s = y2; s >= y1; s--) {
                board[x2][s] = arrNum.get(idx++);
            } // 아래
            for(int w = x2-1; w >= x1; w--) {
                board[w][y1] = arrNum.get(idx++);
            } // 왼쪽
        }
        return answer;
    }
}