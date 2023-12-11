// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PuPq6AaQDFAUq
// 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하라.
// 성공. 

package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] board = new int[n][n];
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < n; col++) {
					board[row][col] = sc.nextInt();
				}
			}
			int answer = 0;
			int cnt = 0;
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < n; col++) {
					if(board[row][col] == 1) {
						cnt++;
					} else {
						if(cnt == k) {
							answer++;
						}
						cnt = 0;
					}
				}
				if(cnt == k) {
					answer++;
				}
				cnt = 0;
			}
			for(int col = 0; col < n; col++) {
				for(int row = 0; row < n; row++) {
					if(board[row][col] == 1) {
						cnt++;
					} else {
						if(cnt == k) {
							answer++;
						}
						cnt = 0;
					}
				}
				if(cnt == k) {
					answer++;
				}
				cnt = 0;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
