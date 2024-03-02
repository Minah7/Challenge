// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB

// 퀸은 같은 행, 열, 또는 대각선 위에 있는 말을 공격할 수 있다.
// N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수는 몇가지가 있을까?
// N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

// 성공

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			answer = 0;
			int n = sc.nextInt();
			int[] board = new int[n];
			boolean[] visited = new boolean[n];
			dfs(visited, board, n, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void dfs(boolean[] visited, int[] board, int n, int depth) {
		if(depth == n) {
			answer++;
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				if(depth > 0) {
					boolean flag = false;
					for(int d = 0; d < depth; d++) {
						if(board[d] == (i - (depth - d))) {
							flag = true;
							break;
						}
						if(board[d] == (i + (depth - d))) {
							flag = true;
							break;
						}
					}
					if(flag) {
						continue;
					}
				}
				visited[i] = true;
				board[depth] = i;
				dfs(visited, board, n, depth + 1);
				visited[i] = false;
			}
		}
	}
}
