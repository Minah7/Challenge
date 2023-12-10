// 문제링크: https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AXuARWAqDkQDFARa
// 한 번에 잡을 수 있는 최대 파리수를 출력하라.
// 성공. Q0741문제 더 짧게 수정

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	// 상, 우, 하, 좌
	static int[][] crossP = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	// 상우, 하우, 하좌, 상좌
	static int[][] crossX = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };

	
	public static int getMax(int[][] board, int n, int m, int row, int col) {
		int sumP = board[row][col];
		int sumX = board[row][col];
		
		for(int dir = 0; dir < 4; dir++) {
			for(int spread = 1; spread < m; spread++) {
				int nrP = row + crossP[dir][0]*spread;
				int ncP = col + crossP[dir][1]*spread;
				if(0 <= nrP && nrP < n && 0 <= ncP && ncP < n) {
					sumP += board[nrP][ncP];
				} // + 방향 값 구하기
				
				int nrX = row + crossX[dir][0]*spread;
				int ncX = col + crossX[dir][1]*spread;
				if(0 <= nrX && nrX < n && 0 <= ncX && ncX < n) {
					sumX += board[nrX][ncX];
				} // x 방향 값 구하기
			} // m 크기만큼 분사
		} // 4방향 탐색
		
		return Math.max(sumP, sumX); //둘 중 큰 값 리턴
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
					answer = Math.max(answer, getMax(board, n, m, row, col));
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}