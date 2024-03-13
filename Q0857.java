// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/64061

// 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 
// 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 
// 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        
        int[] top = new int[n];
        for(int c = 0; c < n; c++) {
            for(int r = 0; r < n; r++) {
                if(board[r][c] != 0) {
                    top[c] = r;
                    break;
                }
                if(r == n - 1) {
                    top[c] = n;
                }
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;
            int row = top[col];
            if(row == n) {
                continue;
            }
            int get = -1;
            if(stack.size() != 0) {
                get = stack.peek();
            }
            
            if(board[row][col] == get) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(board[row][col]);
            }
            
            top[col]++;
        }
        
        return answer;
    }
}