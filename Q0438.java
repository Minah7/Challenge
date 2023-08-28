// 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 
// 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

// 성공

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int r = 0; r < arr1.length; r++) {
            for(int c = 0; c < arr1[0].length; c++) {
                answer[r][c] = arr1[r][c]+arr2[r][c];
            }
        }
        return answer;
    }
}