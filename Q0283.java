// N X N 크기의 단어 퍼즐을 만들려고 한다. 
// 입력으로 단어 퍼즐의 모양이 주어진다.
// 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] puzzle = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					puzzle[r][c] = sc.nextInt();
				}	
			}
			int possible = 0;
			int cnt = 0;
			for(int r = 0; r < N; r++ ) {
				for(int c = 0; c < N; c++) {
					if(puzzle[r][c] == 1) {
						cnt++;
					} else {
						if(cnt == K) {
							possible++;
						}
						cnt = 0;
					}
				}
				if(cnt == K) {
					possible++;
				}
				cnt = 0;
			}
			
			for(int c = 0; c < N; c++) {
				for(int r = 0; r < N; r++) {
					if(puzzle[r][c] == 1) {
						cnt++;
					} else {
						if(cnt == K) {
							possible++;
						}
						cnt = 0;
					}
				}
				if(cnt == K) {
					possible++;
				}
				cnt = 0;
			}
			System.out.println("#"+testCase+" "+possible);
		}
	}
}