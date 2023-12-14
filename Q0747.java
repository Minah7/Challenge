// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
// 다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    // 순서 : 우, 하, 좌, 상
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];

			int num = 1; // 넣어줄 값
			int row = 0; // 시작 행
			int col = 0; // 시작 열
			int d = 0; // 방향 값

			while (num <= n * n) {
				board[row][col] = num;
				num++;
				int nr = row + dir[d][0];
				int nc = col + dir[d][1];
				if (0 <= nr && nr < n && 0 <= nc && nc < n && board[nr][nc] == 0) {
					row = nr;
					col = nc;
				} else {
					d = (d + 1) % 4;
					row = row + dir[d][0];
					col = col + dir[d][1];
				}
			}
			
			System.out.println("#" + tc);
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}// 출력
		}
	}
}
