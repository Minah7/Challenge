// 다음 100X100의 2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하는 프로그램을 작성하여라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int testcase = 1; testcase <= T; testcase++) {
            int tc = sc.nextInt();
            int[][] map = new int[100][100];
            for(int row = 0; row < 100; row++) {
                for(int col = 0; col < 100; col++) {
                    map[row][col] = sc.nextInt();
                }
            }
            int max = 0;
            for(int r = 0; r < 100; r++) {
                int sumRow = 0;
                for(int c = 0; c < 100; c++) {
                    sumRow += map[r][c];
                }
                if(sumRow > max) {
                    max = sumRow;
                }
            }

            for(int c = 0; c < 100; c++) {
                int sumCol = 0;
                for(int r = 0; r < 100; r++) {
                    sumCol += map[r][c];
                }
                if(sumCol > max) {
                    max = sumCol;
                }
            }

            int sumDiagL = 0;
            for(int i = 0; i < 100; i++) {
                sumDiagL += map[i][i];
            }
            if(sumDiagL > max) {
                max = sumDiagL;
            }

            int sumDiagR = 0;
            for(int i = 0; i < 100; i++) {
                sumDiagR += map[i][99-i];
            }
            if(sumDiagR > max) {
                max = sumDiagR;
            }
            System.out.println("#"+testcase+" "+max);
        }
    }
}