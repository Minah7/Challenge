오목게임. 정확히 5개인지 찾기

성공

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
            String answer = "NO";
			row: for(int row = 0; row < N; row++) {
				for(int col = 0; col <N; col++) {
					if(board[row][col] == 'o' ) {
						for(int d = 0; d < 4; d++) {
							int nr = row;
							int nc = col;
							int cnt = 1;
							while(true) {
								nr += dr[d];
								nc += dc[d];
								if(0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] == 'o') {
									cnt++;
								} else break;
							}
							
							nr = row;
							nc = col;
							while(true) {
								nr -= dr[d];
								nc -= dc[d];
								if(0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] == 'o') {
									cnt ++;
								} else break;
							}
                            if(cnt == 5) {
                            	answer = "YES";
                            	break row;
                            }
						}
					}
				}
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}