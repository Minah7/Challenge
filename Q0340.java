// 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 
// 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

// 성공

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //답을 위한 2차원 배열 생성
        int[][] answer = new int[arr1.length][arr1[0].length];
        //반복문을 돌려가며 arr1값과 arr2 값 더해주기
        for(int row = 0; row < arr1.length; row++) {
            for(int col = 0; col < arr1[0].length; col++) {
                //arr1과 arr2의 합을 answer 배열의 같은 위치에 넣어주기 위한 식
                answer[row][col] = arr1[row][col]+arr2[row][col];
            }
        }
        return answer;
    }
}