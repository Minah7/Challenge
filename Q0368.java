// N X N 크기의 판이 있다. 
// 판의 각 칸에는 돌이 있거나 없을 수 있다. 
// 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static int[] dr = {0, 1, 1, 1};
	public static int[] dc = {1, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			char[][] board = new char[N][N];
			for(int row = 0; row < N; row++) {
				board[row] = sc.next().toCharArray();
			}
			String answer  = "NO";
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					if(board[row][col] == 'o') {
						for(int d = 0; d < 4; d++) {
							int cnt = 1;
							int nr = row;
							int nc = col;
							while(true) {
								nr += dr[d];
								nc += dc[d];
								if(0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] == 'o') {
									cnt++;
								} else {
									break;
								}
							}
                            if(cnt >= 5) {
							answer = "YES";
							}
						}
					}
				}
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}