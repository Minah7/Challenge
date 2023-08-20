// 달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
// 다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.

// 성공

import java.util.Scanner;

public class 달팽이숫자1 {
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			int row = 0;
			int col = 0;
			int dir = 0;
			int num = 1;
			board[row][col] = num++;
			while(num <= N*N) {
				int nr = row+dr[dir];
				int nc = col+dc[dir];
				if(0 > nr || nr >= N || 0 > nc || nc >= N || board[nr][nc] > 0) {
					dir = (dir+1)%4;
					nr = row+dr[dir];
					nc = col+dc[dir];
				}
				row = nr;
				col = nc;
				board[row][col] = num++;
			}
			System.out.println("#"+testcase);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(board[r][c]+" ");
				}
				System.out.println();
			}
		}
	}
}
