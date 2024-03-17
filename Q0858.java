// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12949

// 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] answer = new int[row][col];
        
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                int sum = 0;
                for(int i = 0; i < arr2.length; i++) {
                    sum += arr1[r][i] * arr2[i][c];
                }
                answer[r][c] = sum;
                
            }
        }
        
        return answer;
    }
}