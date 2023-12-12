// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq
// 입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 
// 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력한다.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int[][] sudoku = new int[9][9];
			for(int row = 0; row < 9; row++) {
				for(int col = 0; col < 9; col++) {
					sudoku[row][col] = sc.nextInt();
				}
			} // 입력값
			int answer = 1;
			//가로 확인
			out: for(int row = 0; row < 9; row++) {
				boolean[] check = new boolean[9];
				for(int col = 0; col < 9; col++) {
					check[sudoku[row][col]-1] = true;
				}
				for(int i = 0; i < 9; i++) {
					if(!check[i]) {
						answer = 0;
						break out;
					}
				}
			}
			//세로 확인
			if(answer == 1) {
				out: for(int col = 0; col < 9; col++) {
					boolean[] check = new boolean[9];
					for(int row = 0; row < 9; row++) {
						check[sudoku[row][col]-1] = true;
					}
					for(int i = 0; i < 9; i++) {
						if(!check[i]) {
							answer = 0;
							break out;
						}
					}
				}
			}
			//3x3 확인
			if(answer == 1) {
				out: for(int row = 0; row < 9; row += 3) {
					for(int col = 0; col < 9; col += 3) {
						boolean[] check = new boolean[9];
						for(int r = 0; r < 3; r++) {
							for(int c = 0; c < 3; c++) {
								check[sudoku[row+r][col+c]-1] = true;
							}
						}
						for(int i = 0; i < 9; i++) {
							if(!check[i]) {
								answer = 0;
								break out;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}