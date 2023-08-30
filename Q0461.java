// 이차원 정수 배열 arr이 매개변수로 주어집니다. 
// arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고, 
// 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.

// 성공

class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        if(row > col) {
            int[][] answer = new int[row][row];
            for(int r = 0; r < row; r++) {
                for(int c = 0; c < row; c++) {
                    if(c < col) {
                        answer[r][c] = arr[r][c];
                    } else {
                        answer[r][c] = 0;
                    }
                }
            }
            return answer;
        } else if(row < col) {
            int[][] answer = new int[col][col];
            for(int r = 0; r < col; r++) {
                for(int c = 0; c < col; c++) {
                    if(r < row) {
                        answer[r][c] = arr[r][c];
                    } else {
                        answer[r][c] = 0;
                    }
                }
            }
            return answer;
        } else {
            int[][] answer = new int[row][row];
            for(int r = 0; r < row; r++) {
                for(int c = 0; c < col; c++) {
                    answer[r][c] = arr[r][c];
                }
            }
            return answer;
        }
    }
}