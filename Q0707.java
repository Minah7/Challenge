// N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미한다.
// 아래는 N=5 의 예이다.
// M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다.
// 죽은 파리의 개수를 구하라!
// 예를 들어 M=2 일 경우 위 예제의 정답은 49마리가 된다.

// 성공

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n][n];
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			int answer = 0;
			for(int r = 0; r < n-m+1; r++) {
				for(int c = 0; c < n-m+1; c++) {
					int cnt = 0;
					for(int row = r; row < r+m; row++) {
						for(int col = c; col < c+m; col++) {
							cnt+=map[row][col];
						}
					}
					answer = Math.max(answer, cnt);
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
