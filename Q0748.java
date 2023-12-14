// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ
// N X N 크기의 판이 있다. 판의 각 칸에는 돌이 있거나 없을 수 있다. 
// 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정하는 프로그램을 작성하라.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			char[][] board = new char[n][n];
			for (int row = 0; row < n; row++) {
				board[row] = sc.next().toCharArray();
			} // 여기까지 입력값

			String answer = "NO";
			
			// 다섯 개 이상 연속한 돌이 있는지 탐색
			loop: for (int place1 = 0; place1 < n; place1++) {
				for (int place2 = 0; place2 <= n - 5; place2++) {
					// 가로 확인
					for (int i = 0; i < 5; i++) {
						if (board[place1][place2 + i] == '.') {
							break;
						}
						if (i == 4) {
							answer = "YES";
							break loop;
						}
					}
					// 세로 확인
					for(int i = 0; i < 5; i++) {
						if(board[place2+i][place1] == '.') {
							break;
						}
						if(i == 4) {
							answer = "YES";
							break loop;
						}
					}
				}
			}
			// 대각선 확인
			loop: for(int place1 = 0; place1 <= n-5; place1++) {
				for(int place2 = 0; place2 <= n-5; place2++) {
					//좌상에서 우하 방향 탐색
					for(int i = 0; i < 5; i++) {
						if(board[place1+i][place2+i] == '.') {
							break;
						}
						if(i == 4) {
							answer = "YES";
							break loop;
						}
					}
					//우상에서 좌하 방향 탐색
					for(int i = 0; i < 5; i++) {
						if(board[place1+i][n-1-place2-i] == '.') {
							break;
						}
						if(i == 4) {
							answer = "YES";
							break loop;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}