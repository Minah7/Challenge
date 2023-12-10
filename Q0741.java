// 문제링크: https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AXuARWAqDkQDFARa
// 한 번에 잡을 수 있는 최대 파리수를 출력하라.
// 성공

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	// 상, 우, 하, 좌
	static int[][] crossP = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	// 상우, 하우, 하좌, 상좌
	static int[][] crossX = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };

	public static int getCrossP(int[][] board, int n, int m, int row, int col) {
		int sumP = board[row][col];
		
		for(int dir = 0; dir < 4; dir++) {
			for(int spread = 1; spread < m; spread++) {
				int nr = row + crossP[dir][0]*spread;
				int nc = col + crossP[dir][1]*spread;
				if(0 <= nr && nr < n && 0 <= nc && nc < n) {
					sumP += board[nr][nc];
				} else {
					break;
				}
			} // m 크기만큼 분사
		} // 4방향 탐색
		return sumP;
	}

	public static int getCrossX(int[][] board, int n, int m, int row, int col) {
		int sumX = board[row][col];
		
		for(int dir = 0; dir < 4; dir++) {
			for(int spread = 1; spread < m; spread++) {
				int nr = row + crossX[dir][0]*spread;
				int nc = col + crossX[dir][1]*spread;
				if(0 <= nr && nr < n && 0 <= nc && nc < n) {
					sumX += board[nr][nc];
				} else {
					break;
				}
			} // m 크기만큼 분사
		} // 4방향 탐색
		return sumX;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] board = new int[n][n];
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < n; col++) {
					board[row][col] = sc.nextInt();
				}
			} //여기까지 입력값
			
			int answer = 0;
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < n; col++) {
					//getCrossP & getCrossX 값 구해서 그중 최댓값 구하기
					int sum = Math.max(getCrossP(board, n, m, row, col), getCrossX(board, n, m, row, col));
					//answer과 sum 비교하여 최댓값 구하기
					answer = Math.max(answer, sum);
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}